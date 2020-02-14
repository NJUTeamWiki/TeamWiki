package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.ShareVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.Tables;
import cn.edu.nju.teamwiki.jooq.tables.daos.DocumentDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.ShareDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Share;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.service.ShareService;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.StorageUtil;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.LinkedList;
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
    private TeamWikiConfig twConfig;

    @Autowired
    private DSLContext dslContext;

    @Override
    public List<ShareVO> getAllShares() throws ServiceException {
        return shareDao.findAll()
                .stream()
                .map(share -> new ShareVO(share))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShareVO> getSharesByUserId(String userId) throws ServiceException {
        return shareDao.fetchByShareUser(Integer.valueOf(userId))
                .stream()
                .map(share -> new ShareVO(share))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShareVO> getSharesByTitle(String shareTitle) throws ServiceException {
        return shareDao.fetchByShareTitle(shareTitle)
                .stream()
                .map(share -> new ShareVO(share))
                .collect(Collectors.toList());
    }

    @Override
    public ShareVO createShare(String shareTitle, String shareContent, String userId, MultipartFile file) throws ServiceException {
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

        share = getShare(userId, share.getShareTime());

        Path urlPath = Paths.get(StorageUtil.SHARE_PATH,
                share.getShareId().toString(),
                shareFileName);

        Path storagePath = Paths.get(twConfig.storagePath).resolve(urlPath);

        LOG.info("Share [" + share.getShareId() + "]'s file will be stored as [" + storagePath + "]");

        try {
            StorageUtil.storeFile(storagePath, file);
        } catch (IOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }

        Document document = new Document();
        document.setSourceId(share.getShareId());
        document.setSourceType(Constants.SOURCE_SHARE);
        document.setUrl(urlPath.toString());
        document.setUploadedTime(LocalDateTime.now());
        document.setModifiedTime(document.getUploadedTime());
        document.setDName(shareFileName);
        document.setUploader(Integer.valueOf(userId));

        List<Document> documents = new LinkedList<>();
        documents.add(document);

        return new ShareVO(share, documents);
    }

    @Override
    public ShareVO updateShare(String shareId, String shareTitle, String shareContent, String userId) throws ServiceException {
        Share share = shareDao.fetchOneByShareId(Integer.valueOf(shareId));
        if (!userId.equals(String.valueOf(share.getShareUser()))) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }
//        share.setShareUser(Integer.valueOf(userId));
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
    public ShareVO deleteShare(String shareId, String userId) throws ServiceException {
        Share share = shareDao.fetchOneByShareId(Integer.valueOf(shareId));
        if (!userId.equals(String.valueOf(share.getShareUser()))) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }

        shareDao.deleteById(Integer.valueOf(shareId));

        List<Document> documents = getShareDocuments(shareId);
        for (Document document : documents) {
            String url = document.getUrl();
            try {
                Files.delete(Paths.get(twConfig.storagePath).resolve(url));
            } catch (IOException e) {
                LOG.error(e.getMessage());
                throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
            }
        }
        return new ShareVO(share);
    }

    private Share getShare(String userId, LocalDateTime time) {
        return dslContext.selectFrom(Tables.SHARE)
                .where(Tables.SHARE.SHARE_USER.eq(Integer.valueOf(userId)))
                .and(Tables.SHARE.SHARE_TIME.eq(time))
                .fetchOneInto(Share.class);
    }

    private List<Document> getShareDocuments(String shareId) {
        return dslContext.selectFrom(Tables.DOCUMENT)
                .where(Tables.DOCUMENT.SOURCE_TYPE.eq(Constants.SOURCE_SHARE))
                .and(Tables.DOCUMENT.SOURCE_ID.eq(Integer.valueOf(shareId)))
                .fetchInto(Document.class);
    }
}
