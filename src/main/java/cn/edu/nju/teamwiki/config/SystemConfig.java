package cn.edu.nju.teamwiki.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: xuyangchen
 * @date: 2020/1/6
 */
@Component
@PropertySource("classpath:teamwiki.properties")
public class SystemConfig {

    @Value("${teamwiki.storage.path}")
    public String storagePath;

}
