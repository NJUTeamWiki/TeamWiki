package cn.edu.nju.teamwiki.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: xuyangchen
 * @date: 2020/1/6
 */
@Configuration
@PropertySource("classpath:teamwiki.properties")
public class SystemConfig {

    @Value("${teamwiki.storage.path}")
    public String storagePath;

    public String knowledgeStoragePath = storagePath + "/knowledge";

    public String shareStoragePath = storagePath + "/share";

}
