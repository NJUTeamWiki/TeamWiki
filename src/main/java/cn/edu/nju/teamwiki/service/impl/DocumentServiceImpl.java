package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.DocumentActivityVO;
import cn.edu.nju.teamwiki.api.vo.DocumentVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.tables.daos.DocumentActivitiesDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.DocumentDao;
import cn.edu.nju.teamwiki.jooq.tables.daos.UserDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.jooq.tables.pojos.DocumentActivities;
import cn.edu.nju.teamwiki.jooq.tables.pojos.User;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.ServiceException;
import cn.edu.nju.teamwiki.util.Constants;
import cn.edu.nju.teamwiki.util.TimeUtils;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static cn.edu.nju.teamwiki.jooq.Tables.DOCUMENT_ACTIVITIES;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Autowired
    private DocumentDao documentDao;

    @Autowired
    private DocumentActivitiesDao activitiesDao;

    @Autowired
    private DSLContext dslContext;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TeamWikiConfig twConfig;

    @Override
    public Path getDocumentAbsolutePath(String documentId) {
        Document document = documentDao.fetchOneByDId(documentId);
        return Paths.get(twConfig.docDir, document.getUrl());
    }

    @Override
    public String getDocumentName(String documentId) {
        Document document = documentDao.fetchOneByDId(documentId);
        if (document == null) {
            throw new ServiceException(ResultCode.DATA_NOT_EXIST);
        }
        return documentDao.fetchOneByDId(documentId).getDName();
    }

    @Override
    public List<DocumentVO> getDocuments(String sourceId, Integer sourceType) {
        return documentDao.fetchBySourceId(Integer.valueOf(sourceId))
                .stream()
                .filter(document -> document.getSourceType().equals(sourceType))
                .filter(document -> !document.getIsArchived())
                .map(document -> {
                    User uploader = userDao.fetchOneByUserId(document.getUploader());
                    DocumentVO documentVO = new DocumentVO(document);
                    documentVO.setUploaderName(uploader.getUsername());
                    return documentVO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public DocumentVO createDocument(String documentName, String uploaderId, String sourceId, Integer sourceType, String url) {
        Document document = new Document();
        document.setDId(UUID.randomUUID().toString().replace("-", ""));
        document.setDName(documentName);
        document.setUploader(Integer.valueOf(uploaderId));
        document.setSourceId(Integer.valueOf(sourceId));
        document.setSourceType(sourceType);
        document.setUrl(url);
        document.setUploadedTime(LocalDateTime.now());
        document.setModifiedTime(document.getUploadedTime());
        documentDao.insert(document);

        DocumentActivities activity = new DocumentActivities();
        activity.setUserId(document.getUploader());
        activity.setAction(Constants.ACTION_CREATE);
        activity.setDocumentId(document.getDId());
        activity.setTime(document.getUploadedTime());
        activitiesDao.insert(activity);

        return new DocumentVO(document);
    }

    @Override
    public DocumentVO renameDocument(String documentId, String newName, String userId) {
        Document document = documentDao.fetchOneByDId(documentId);

        if (!userId.equals(document.getUploader().toString())) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }

        Path documentPath = Paths.get(twConfig.docDir, document.getUrl());

        File oldDocument = documentPath.toFile();
        File newDocument = documentPath.getParent().resolve(newName).toFile();
        if (oldDocument.renameTo(newDocument)) {
            document.setDName(newName);
            document.setModifiedTime(LocalDateTime.now());
            documentDao.update(document);
        } else {
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }

        DocumentActivities activity = new DocumentActivities();
        activity.setUserId(document.getUploader());
        activity.setAction(Constants.ACTION_UPDATE);
        activity.setDocumentId(document.getDId());
        activity.setTime(document.getModifiedTime());
        activitiesDao.insert(activity);

        return new DocumentVO(documentDao.fetchOneByDId(document.getDId()));
    }

    @Override
    public DocumentVO deleteDocument(String documentId, String userId) {
        Document document = documentDao.fetchOneByDId(documentId);

        if (!userId.equals(document.getUploader().toString())) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }

//        Path documentPath = Paths.get(twConfig.docDir, document.getUrl());
//        if (!StorageUtils.deleteFile(documentPath)) {
//            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
//        }
//
//        documentDao.delete(document);
        // 不对文档进行删除，而是进行归档
        document.setIsArchived(true);
        documentDao.update(document);

        DocumentActivities activity = new DocumentActivities();
        activity.setUserId(document.getUploader());
        activity.setAction(Constants.ACTION_DELETE);
        activity.setDocumentId(document.getDId());
        activity.setTime(LocalDateTime.now());
        activitiesDao.insert(activity);

        return new DocumentVO(document);
    }

    @Override
    public List<DocumentActivityVO> getDocumentActivities() {
        List<DocumentActivities> documentActivities = dslContext.selectFrom(DOCUMENT_ACTIVITIES)
                .orderBy(DOCUMENT_ACTIVITIES.TIME.desc())
                .limit(10)
                .fetchInto(DocumentActivities.class);

        List<DocumentActivityVO> vos = documentActivities.stream()
                .map(documentActivity -> {
                    Document document = documentDao.fetchOneByDId(documentActivity.getDocumentId());
                    User user = userDao.fetchOneByUserId(documentActivity.getUserId());
                    DocumentActivityVO activityVO = new DocumentActivityVO(
                            String.valueOf(user.getUserId()), user.getUsername(), user.getAvatar(),
                            documentActivity.getAction(),
                            document.getDId(), document.getDName(),
                            TimeUtils.getPrettyGapString(documentActivity.getTime()));
                    return activityVO;
                })
                .collect(Collectors.toList());

        return vos;
    }
}
