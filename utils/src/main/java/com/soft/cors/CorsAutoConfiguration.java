package com.soft.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>ClassName:     CorsAutoConfiguration
 * <p>Description:   配置跨域支持
 * <p>Version        V1.0
 */

@Configuration
public class CorsAutoConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域请求，url前缀必须为/api
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "PUT", "DELETE", "GET")
                .allowCredentials(false).maxAge(3600);

        /*registry.addMapping("/public*//**")
                .allowedOrigins("*")
                .allowedMethods("GET")
                .allowCredentials(false).maxAge(3600);

        registry.addMapping("/debug*//**")
                .allowedOrigins("*")
                .allowedMethods("POST", "PUT", "DELETE", "GET")
                .allowCredentials(false).maxAge(3600);*/
    }
}
