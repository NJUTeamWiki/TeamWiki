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
public class TeamWikiConfig {

    @Value("${teamwiki.storage.root}")
    public String rootDir;

    @Value("${teamwiki.storage.img}")
    public String imgDir;

    @Value("${teamwiki.storage.img.avatar}")
    public String avatarDir;

    @Value("${teamwiki.storage.img.icon}")
    public String iconDir;

    @Value("${teamwiki.storage.doc}")
    public String docDir;

    @Value("${teamwiki.storage.doc.knowledge}")
    public String knowledgeDir;

    @Value("${teamwiki.storage.doc.share}")
    public String shareDir;


}
