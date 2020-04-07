package cn.edu.nju.teamwiki.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author: xuyangchen
 * @date: 2020/4/7
 */
public class UploadFileUtils {

    public static boolean isImage(MultipartFile file) throws IOException {
        BufferedImage bi = ImageIO.read(file.getInputStream());
        return bi != null && bi.getWidth() <= 0 && bi.getHeight() <= 0;
    }

    public static void transfer(MultipartFile file, Path storagePath) throws IOException {
        File storageFile = storagePath.toFile();
        if (!storageFile.getParentFile().exists()) {
            storageFile.getParentFile().mkdirs();
        }
        file.transferTo(storageFile.getAbsoluteFile());
    }

}
