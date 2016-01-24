package com.ayp.sms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ayp.sms.interceptors.AuthenticationInterceptor;

/**
 * 
 * @author rana
 *
 */

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan (basePackages = {"com.ayp.sms"})
public class AppConfig extends WebMvcConfigurerAdapter {

    
    @Bean
    public StandardServletMultipartResolver multipartResolver(){
        return new StandardServletMultipartResolver();
    }

    @Bean
    public ViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver =
            new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/fonts/");
        registry.addResourceHandler("/swf/**").addResourceLocations("/swf/");
    }

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(getAuthenticationInterceptor())
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/swf/**");
    }
    
    @Bean
    public AuthenticationInterceptor getAuthenticationInterceptor () {
        return new AuthenticationInterceptor();
    }
    
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}