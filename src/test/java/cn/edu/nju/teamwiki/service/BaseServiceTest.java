package cn.edu.nju.teamwiki.service;

import cn.edu.nju.teamwiki.config.SystemConfig;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.BeforeTestClassEvent;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author: xuyangchen
 * @date: 2020/1/17
 */
@SpringBootTest
public class BaseServiceTest {

    @Autowired
    private SystemConfig systemConfig;

    private File testStorageDir;

    protected void before() throws Exception {
        Path testPath = Paths.get(getClass().getResource("").getPath());
        Path testStoragePath = Files.createTempDirectory(testPath, "test");
        testStorageDir = testStoragePath.toFile();
        systemConfig.storagePath = testStoragePath.toString();
        systemConfig.knowledgeStoragePath = testStoragePath.resolve("knowledge").toString();
        systemConfig.shareStoragePath = testStoragePath.resolve("share").toString();
    }

    protected void after() throws Exception {
        FileUtils.deleteDirectory(testStorageDir);
    }

}
