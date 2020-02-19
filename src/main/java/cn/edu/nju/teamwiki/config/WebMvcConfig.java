package cn.edu.nju.teamwiki.config;

import cn.edu.nju.teamwiki.interceptor.SignInInterceptor;
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
    public TeamWikiConfig twConfig;

    @Autowired
    public SignInInterceptor signInInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/storage/**")
                .addResourceLocations("file:" + twConfig.storagePath + "/");
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
