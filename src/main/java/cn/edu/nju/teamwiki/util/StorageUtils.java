package cn.edu.nju.teamwiki.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author: xuyangchen
 * @date: 2020/1/7
 */
public class StorageUtils {

    private final static Logger LOG = LoggerFactory.getLogger(StorageUtils.class);

    public static boolean deleteFile(Path filePath) {
        try {
            FileSystemUtils.deleteRecursively(filePath);
        } catch (IOException e) {
            LOG.error("Failed to delete file, due to", e);
            return false;
        }
        return true;
    }

    public static String getFileSuffixName(File file) {
        String name = file.getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    public static String getFilePrefixName(File file) {
        String name = file.getName();
        return name.substring(0, name.lastIndexOf("."));
    }

}
