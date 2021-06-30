package com.onlineclass.tibet_online_class.config;

import com.onlineclass.tibet_online_class.interception.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * configuring 1  the block path /api/v1/pri/ path
 *             2  allowing the /api/v1/pub  path
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    LoginInterceptor loginInterceptor(){
        return new LoginInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                // excluding the login and register path
                .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
