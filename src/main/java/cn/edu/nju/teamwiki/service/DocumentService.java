package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.api.vo.DocumentVO;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;

/**
 * @author: xuyangchen
 * @date: 2020/1/16
 */
public interface DocumentService {

    Path getDocumentDownloadPath(String documentId) throws ServiceException;

    List<DocumentVO> getDocuments(String sourceId, Integer sourceType) throws ServiceException;

    void uploadDocument(String sourceId, Integer sourceType,
                        MultipartFile file, String userId) throws ServiceException;

    void renameDocument(String documentId, Integer sourceType,
                        String newName, String userId) throws ServiceException;

    void deleteDocument(String documentId, Integer sourceType,
                        String userId) throws ServiceException;

}
