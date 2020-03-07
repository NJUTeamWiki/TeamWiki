package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.ShareVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.Tables;
import cn.edu.nju.teamwiki.jooq.tables.daos.DocumentDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.ShareDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Share;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.ShareService;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.StorageUtils;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhoushiqi
 * @date: 2020/2/5
 */
@Service
public class ShareServiceImpl implements ShareService {

    private static final Logger LOG = LoggerFactory.getLogger(ShareServiceImpl.class);

    @Autowired
    private ShareDao shareDao;

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private TeamWikiConfig twConfig;

    @Autowired
    private DSLContext dslContext;

    @Override
    public List<ShareVO> getAllShares() {

        return shareDao.findAll()
                .stream()
                .map(share -> {
                    List<Document> documents = getShareDocuments(String.valueOf(share.getShareId()));
                    return new ShareVO(share, documents);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ShareVO> getSharesByUserId(String userId) {
        return shareDao.fetchByShareUser(Integer.valueOf(userId))
                .stream()
                .map(share -> {
                    List<Document> documents = getShareDocuments(String.valueOf(share.getShareId()));
                    return new ShareVO(share, documents);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ShareVO> getSharesByTitle(String shareTitle) {
        return shareDao.fetchByShareTitle(shareTitle)
                .stream()
                .map(share -> {
                    List<Document> documents = getShareDocuments(String.valueOf(share.getShareId()));
                    return new ShareVO(share, documents);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ShareVO createShare(String shareTitle, String shareContent, String userId, MultipartFile file) {
        String shareFileName = file.getOriginalFilename();
        if (shareFileName == null || shareFileName.isEmpty()) {
            throw new ServiceException(ResultCode.PARAM_INVALID_UPLOAD_FILE);
        }

        Share share = new Share();
        share.setShareTitle(shareTitle);
        share.setShareContent(shareContent);
        share.setShareUser(Integer.valueOf(userId));
        share.setShareTime(LocalDateTime.now());
        shareDao.insert(share);

        share = getLastShare(userId);

        Path storagePath = Paths.get(twConfig.shareDir, share.getShareId().toString(), shareFileName);
        Path urlPath = Paths.get(twConfig.docDir).relativize(storagePath);
        LOG.info("Share [" + share.getShareId() + "]'s file will be stored as [" + storagePath + "]");

        if (!StorageUtils.storeMultipartFile(storagePath, file)) {
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }

        documentService.createDocument(shareFileName,
                userId, String.valueOf(share.getShareId()), Constants.SOURCE_SHARE, urlPath.toString());
        List<Document> documents = getShareDocuments(String.valueOf(share.getShareId()));

        return new ShareVO(share, documents);
    }

    @Override
    public ShareVO updateShare(String shareId, String shareTitle, String shareContent, String userId) {
        Share share = shareDao.fetchOneByShareId(Integer.valueOf(shareId));
        if (share == null) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST);
        }
        if (!userId.equals(String.valueOf(share.getShareUser()))) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }
        if (StringUtils.isEmpty(shareTitle)) {
            share.setShareTitle(shareTitle);
        }

        if (StringUtils.isEmpty(shareContent)) {
            share.setShareContent(shareContent);
        }
//        share.setShareTime(LocalDateTime.now());
        shareDao.update(share);

        return new ShareVO(
                shareDao.fetchOneByShareId(Integer.valueOf(shareId)),
                getShareDocuments(shareId));
    }

    @Override
    public ShareVO deleteShare(String shareId, String userId) {
        Share share = shareDao.fetchOneByShareId(Integer.valueOf(shareId));
        if (share == null) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST);
        }
        if (!userId.equals(String.valueOf(share.getShareUser()))) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }

        List<Document> documents = getShareDocuments(shareId);
        for (Document document : documents) {
            documentService.deleteDocument(document.getDId(), userId);
        }

        shareDao.deleteById(Integer.valueOf(shareId));

        return new ShareVO(share);
    }

    private Share getLastShare(String userId) {
        return dslContext.selectFrom(Tables.SHARE)
                .where(Tables.SHARE.SHARE_USER.eq(Integer.valueOf(userId)))
                .orderBy(Tables.SHARE.SHARE_TIME.desc())
                .limit(1)
                .fetchOneInto(Share.class);
    }

    private List<Document> getShareDocuments(String shareId) {
        return dslContext.selectFrom(Tables.DOCUMENT)
                .where(Tables.DOCUMENT.SOURCE_TYPE.eq(Constants.SOURCE_SHARE))
                .and(Tables.DOCUMENT.SOURCE_ID.eq(Integer.valueOf(shareId)))
                .fetchInto(Document.class);
    }
}
