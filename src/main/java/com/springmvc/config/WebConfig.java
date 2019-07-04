package com.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.springmvc.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {


    //需要配置试图转换器
    @Bean
    public ViewResolver addViewControllers() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views");
        resolver.setSuffix(".jsp");
        //可以在jsp页面通过{}访问beans
        resolver.setExposeContextBeansAsAttributes(true);
        System.out.println(resolver);
        return resolver;
    }

}
