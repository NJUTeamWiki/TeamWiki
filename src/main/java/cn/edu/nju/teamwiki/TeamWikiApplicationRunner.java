package cn.edu.nju.teamwiki;

import cn.edu.nju.teamwiki.config.SystemConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.NotDirectoryException;

/**
 * 负责资源等的初始化
 *
 * @author: xuyangchen
 * @date: 2020/1/7
 */
@Component
public class TeamWikiApplicationRunner implements ApplicationRunner {

    private final SystemConfig systemConfig;

    public TeamWikiApplicationRunner(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        File storageDir = new File(systemConfig.storagePath);
//        storageDir.mkdirs();
//        File knowledgeStorageDir = new File(systemConfig.knowledgeStoragePath);
//        knowledgeStorageDir.mkdir();
//        File shareStorageDir = new File(systemConfig.shareStoragePath);
//        shareStorageDir.mkdir();
    }
}
