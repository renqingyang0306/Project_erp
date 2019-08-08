package com.rqy.config;

import com.rqy.converter.String2DateConverter;
import com.rqy.intercepter.MyFirstInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.PostConstruct;


/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/6 20:48
 */
@EnableWebMvc
@ComponentScan(value = "com.rqy.controller",
        includeFilters =@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class) )
public class SpringMvcConfig implements WebMvcConfigurer{

    //注入本身已有的接口
    @Autowired
    ConfigurableConversionService conversionService;
    //把自定义的conversionService重新注册到bean中
    @Bean
    //保证conversionService的唯一性
    @Primary
    public ConfigurableConversionService conversionService(){
        return conversionService;
    }
    //指定执行顺序
    @PostConstruct
    public  void addConverters(){
        String2DateConverter string2DateConverter = new String2DateConverter();
        conversionService.addConverter(string2DateConverter);
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyFirstInterceptor());
        //registry.addInterceptor().addPathPatterns("/abc/**");
    }

    //处理静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
        registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image/");
        registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
    }
    //配置视图解析器
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
}
