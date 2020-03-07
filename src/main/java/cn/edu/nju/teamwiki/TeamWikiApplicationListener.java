package cn.edu.nju.teamwiki;

import cn.edu.nju.teamwiki.util.OfficeUtils;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * @author: xuyangchen
 * @date: 2020/3/21
 */
@Component
public class TeamWikiApplicationListener implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        OfficeUtils.onExit();
    }
}
