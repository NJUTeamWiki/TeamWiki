package cn.edu.nju.teamwiki.util;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */
public class StorageUtil {

    public static Path getKnowledgeStoragePath(String storagePath,
                                               String categoryId,
                                               String knowledgeId) {
        return Paths.get(storagePath, categoryId, knowledgeId);
    }

    public static Path getShareStoragePath(String storagePath,
                                           String shareId) {
        return Paths.get(storagePath, shareId);
    }

    public static Path getKnowledgeDocumentStoragePath(String storagePath,
                                                       String categoryId,
                                                       String knowledgeName,
                                                       String documentName) {
        return getKnowledgeStoragePath(storagePath, categoryId, knowledgeName)
                .resolve(documentName);
    }

    public static Path getShareDocumentStoragePath(String storagePath,
                                                   String shareId,
                                                   String documentName) {
        return getShareStoragePath(storagePath, shareId)
                .resolve(documentName);
    }

}
