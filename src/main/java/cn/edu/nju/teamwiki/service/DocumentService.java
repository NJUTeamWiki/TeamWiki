package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.DocumentVO;

import java.nio.file.Path;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public interface DocumentService {

    Path getDocumentDownloadPath(String documentId) throws ServiceException;

    String getDocumentName(String documentId) throws ServiceException;

    List<DocumentVO> getDocuments(String sourceId, Integer sourceType) throws ServiceException;

//    void uploadDocument(String sourceId, Integer sourceType,
//                        MultipartFile file, String userId) throws ServiceException;

    DocumentVO createDocument(String documentName, String uploaderId, String sourceId, Integer sourceType, String url) throws ServiceException;

    DocumentVO renameDocument(String documentId, String newName, String userId) throws ServiceException;

    DocumentVO deleteDocument(String documentId, String userId) throws ServiceException;

}
