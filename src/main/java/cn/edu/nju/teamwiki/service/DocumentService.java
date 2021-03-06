package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.DocumentActivityVO;
import cn.edu.nju.teamwiki.api.vo.DocumentVO;

import java.nio.file.Path;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public interface DocumentService {

    Path getDocumentAbsolutePath(String documentId);

    String getDocumentName(String documentId);

    List<DocumentVO> getDocuments(String sourceId, Integer sourceType);

//    void uploadDocument(String sourceId, Integer sourceType,
//                        MultipartFile file, String userId) throws ServiceException;

    DocumentVO createDocument(String documentName, String uploaderId, String sourceId, Integer sourceType, String url);

    DocumentVO renameDocument(String documentId, String newName, String userId);

    DocumentVO deleteDocument(String documentId, String userId);

    List<DocumentActivityVO> getDocumentActivities();

}
