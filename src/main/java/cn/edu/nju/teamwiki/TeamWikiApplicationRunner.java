package cn.edu.nju.teamwiki;

import cn.edu.nju.teamwiki.config.TeamWikiConfig;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 负责资源等的初始化
 *
 * @author: xuyangchen
 * @date: 2020/1/7
 */
@Component
public class TeamWikiApplicationRunner implements ApplicationRunner {

    private final TeamWikiConfig twConfig;

    public TeamWikiApplicationRunner(TeamWikiConfig twConfig) {
        this.twConfig = twConfig;
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
