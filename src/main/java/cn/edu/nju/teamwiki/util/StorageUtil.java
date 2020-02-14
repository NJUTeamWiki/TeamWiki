package cn.edu.nju.teamwiki.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */
public class StorageUtil {

    public static final String KNOWLEDGE_PATH = "/knowledge/";

    public static final String SHARE_PATH = "/share/";

    public static final String IMAGE_PATH = "/image/";

    public static final String AVATAR_PATH = IMAGE_PATH + "avatar/";

    public static final String ICON_PATH = IMAGE_PATH + "icon/";

    public static Path getKnowledgeStoragePath(String storagePath,
                                               String categoryId,
                                               String knowledgeId) {
        return Paths.get(storagePath, KNOWLEDGE_PATH, categoryId, knowledgeId);
    }

    public static Path getShareStoragePath(String storagePath,
                                           String shareId) {
        return Paths.get(storagePath, SHARE_PATH, shareId);
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

    public static void storeFile(Path storagePath, MultipartFile file) throws IOException {
        File storageFile = storagePath.toFile();
        if (!storageFile.getParentFile().exists()) {
            storageFile.getParentFile().mkdirs();
        }
        file.transferTo(storageFile);
    }

}
