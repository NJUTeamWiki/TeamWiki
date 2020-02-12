package cn.edu.nju.teamwiki.config;

import cn.edu.nju.teamwiki.interceptor.SignInInterceptor;
import cn.edu.nju.teamwiki.util.StorageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: xuyangchen
 * @date: 2020/2/11
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    public SystemConfig systemConfig;

    @Autowired
    public SignInInterceptor signInInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("file:" + systemConfig.storagePath + StorageUtil.IMAGE_PATH);
        registry.addResourceHandler("/doc/**")
                .addResourceLocations("file:" + systemConfig.storagePath + StorageUtil.SHARE_PATH,
                        "file:" + systemConfig.storagePath + StorageUtil.KNOWLEDGE_PATH);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInInterceptor)
                .excludePathPatterns("/user/sign_**")
                .addPathPatterns("/user/**",
                        "/admin/**",
                        "/document/**",
                        "/knowledge/**",
                        "/portal/**",
                        "/share/**",
                        "/image/**",
                        "/doc/**");
    }
}
