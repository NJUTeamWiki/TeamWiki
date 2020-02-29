package cn.edu.nju.teamwiki.service.impl;

import cn.edu.nju.teamwiki.api.ResultCode;
import cn.edu.nju.teamwiki.api.vo.DocumentVO;
import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import cn.edu.nju.teamwiki.jooq.tables.daos.DocumentDao;
import cn.edu.nju.teamwiki.jooq.tables.pojos.Document;
import cn.edu.nju.teamwiki.service.DocumentService;
import cn.edu.nju.teamwiki.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private static final Logger LOG = LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Autowired
    private DocumentDao documentDao;

//    @Autowired
//    private KnowledgeDao knowledgeDao;
//
//    @Autowired
//    private CategoryDao categoryDao;
//
//    @Autowired
//    private ShareDao shareDao;

    @Autowired
    private TeamWikiConfig twConfig;

    @Override
    public Path getDocumentDownloadPath(String documentId) {
        Document document = documentDao.fetchOneByDId(documentId);
        return Paths.get(twConfig.storagePath, document.getUrl());
//        switch (document.getSourceType()) {
//            case Constants.SOURCE_KNOWLEDGE:
//                Knowledge knowledge = knowledgeDao.fetchOneByKId(document.getSourceId());
//                Category category = categoryDao.fetchOneByCategoryId(knowledge.getCategory());
//                return StorageUtil.getKnowledgeDocumentStoragePath(systemConfig.storagePath,
//                        category.getCategoryName(),
//                        knowledge.getKName(),
//                        document.getDName());
//            case Constants.SOURCE_SHARE:
//                Share share = shareDao.fetchOneByShareId(document.getSourceId());
//                return StorageUtil.getShareDocumentStoragePath(systemConfig.storagePath,
//                        String.valueOf(share.getShareId()),
//                        document.getDName());
//            default:
//                throw new ServiceException(ResultCode.PARAM_INVALID_DOCUMENT_SOURCE);
//        }
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
                .map(DocumentVO::new)
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

        return new DocumentVO(document);
    }

//    @Override
//    public void uploadDocument(String sourceId, Integer sourceType,
//                               MultipartFile file, String userId) throws ServiceException {
//        // 获得文件的字节流
//        byte[] bytes;
//        try {
//            bytes = file.getBytes();
//        } catch (IOException e) {
//            LOG.error(e.getMessage());
//            throw new ServiceException(ResultCode.PARAM_INVALID_UPLOAD_FILE);
//        }
//
//
//        Path sourcePath;
//        if (sourceType == Constants.SOURCE_KNOWLEDGE) {
//            Knowledge knowledge = knowledgeDao.fetchOneByKId(Integer.valueOf(sourceId));
//            Category category = categoryDao.fetchOneByCategoryId(knowledge.getCategory());
//            sourcePath = StorageUtil.getKnowledgeStoragePath(systemConfig.storagePath,
//                    String.valueOf(category.getCategoryId()),
//                    String.valueOf(knowledge.getKId()));
//
//        } else if (sourceType == Constants.SOURCE_SHARE) {
//            Share share = shareDao.fetchOneByShareId(Integer.valueOf(sourceId));
//            sourcePath = StorageUtil.getShareStoragePath(systemConfig.storagePath,
//                    String.valueOf(share.getShareId()));
//        } else {
//            throw new ServiceException(ResultCode.PARAM_INVALID_DOCUMENT_SOURCE);
//        }
//
//        sourcePath.toFile().mkdirs();
//
//        Path documentPath = sourcePath.resolve(file.getOriginalFilename());
//        LOG.info("Document will be stored as [" + documentPath.toString() + "]");
//
//        // 将文件写入到目标路径中
//        try {
//            Files.write(documentPath, bytes, StandardOpenOption.CREATE_NEW);
//        } catch (IOException e) {
//            LOG.error(e.getMessage());
//            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
//        }
//
//        Document document = new Document();
//        document.setDId(UUID.randomUUID().toString());
//        document.setDName(file.getOriginalFilename());
//        document.setUploader(Integer.valueOf(userId));
//        document.setSourceId(Integer.valueOf(sourceId));
//        document.setSourceType(sourceType);
//        document.setUploadedTime(LocalDateTime.now());
//        document.setModifiedTime(LocalDateTime.now());
//        documentDao.insert(document);
//    }

    @Override
    public DocumentVO renameDocument(String documentId, String newName, String userId) {
        Document document = documentDao.fetchOneByDId(documentId);

        if (!userId.equals(document.getUploader().toString())) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }

        Path documentPath = Paths.get(twConfig.storagePath, document.getUrl());
        ;
//        if (sourceType == Constants.SOURCE_KNOWLEDGE) {
//            Knowledge knowledge = knowledgeDao.fetchOneByKId(document.getSourceId());
//            Category category = categoryDao.fetchOneByCategoryId(knowledge.getCategory());
//            sourcePath = StorageUtil.getKnowledgeStoragePath(systemConfig.storagePath,
//                    String.valueOf(category.getCategoryId()),
//                    String.valueOf(knowledge.getKId()),
//                    document.getDId());
//        } else if (sourceType == Constants.SOURCE_SHARE) {
//            Share share = shareDao.fetchOneByShareId(document.getSourceId());
//            sourcePath = StorageUtil.getShareStoragePath(systemConfig.storagePath,
//                    String.valueOf(share.getShareId()));
//        } else {
//            throw new ServiceException(ResultCode.PARAM_INVALID_DOCUMENT_SOURCE);
//        }

        File oldDocument = documentPath.toFile();
        File newDocument = documentPath.getParent().resolve(newName).toFile();
        if (oldDocument.renameTo(newDocument)) {
            document.setDName(newName);
            document.setModifiedTime(LocalDateTime.now());
            documentDao.update(document);
        } else {
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }

        return new DocumentVO(documentDao.fetchOneByDId(document.getDId()));
    }

    @Override
    public DocumentVO deleteDocument(String documentId, String userId) {
        Document document = documentDao.fetchOneByDId(documentId);

        if (!userId.equals(document.getUploader().toString())) {
            throw new ServiceException(ResultCode.PERMISSION_NO_MODIFY);
        }

        Path documentPath = Paths.get(twConfig.storagePath, document.getUrl());

//        if (sourceType == Constants.SOURCE_KNOWLEDGE) {
//            Knowledge knowledge = knowledgeDao.fetchOneByKId(document.getSourceId());
//            Category category = categoryDao.fetchOneByCategoryId(knowledge.getCategory());
//            documentPath = StorageUtil.getKnowledgeDocumentStoragePath(systemConfig.storagePath,
//                    String.valueOf(category.getCategoryId()),
//                    String.valueOf(knowledge.getKId()),
//                    document.getDName());
//        } else if (sourceType == Constants.SOURCE_SHARE) {
//            Share share = shareDao.fetchOneByShareId(document.getSourceId());
//            documentPath = StorageUtil.getShareDocumentStoragePath(systemConfig.storagePath,
//                    String.valueOf(share.getShareId()),
//                    document.getDName());
//        } else {
//            throw new ServiceException(ResultCode.PARAM_INVALID_DOCUMENT_SOURCE);
//        }
        try {
            Files.delete(documentPath);
        } catch (IOException e) {
            LOG.error("文件删除失败", e);
            throw new ServiceException(ResultCode.SYSTEM_FILE_ERROR);
        }
        documentDao.delete(document);

        return new DocumentVO(document);
    }
}
