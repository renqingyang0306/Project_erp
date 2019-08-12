package com.rqy.config;

import com.rqy.converter.String2DateConverter;
import com.rqy.intercepter.MyFirstInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.hibernate.validator.HibernateValidator;

import javax.annotation.PostConstruct;

import java.util.Locale;



/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/6 20:48
 */
@EnableWebMvc
@ComponentScan(value = "com.rqy.controller",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class))
public class SpringMvcConfig implements WebMvcConfigurer {

    //注入本身已有的接口
    @Autowired
    ConfigurableConversionService conversionService;

    //把自定义的conversionService重新注册到bean中
    @Bean
    //保证conversionService的唯一性
    @Primary
    public ConfigurableConversionService conversionService() {
        return conversionService;
    }

    //指定执行顺序
    @PostConstruct
    public void addConverters() {
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
        registry.addResourceHandler("/pic/**").addResourceLocations("/WEB-INF/pic/");

    }
    //配置视图解析器
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
    //校验
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(ReloadableResourceBundleMessageSource messageSource){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        localValidatorFactoryBean.setValidationMessageSource(messageSource);
        return localValidatorFactoryBean;
    }
    //加载国际化的配置文件
    @Bean
    public ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:message");
        //reloadableResourceBundleMessageSource.setFileEncodings(new Properties());
        messageSource.setDefaultEncoding("utf-8");
        messageSource.setCacheSeconds(120);
        messageSource.setUseCodeAsDefaultMessage(false);
        return messageSource;
    }
    @Bean
    public CookieLocaleResolver cookieLocaleResolver(){
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setCookieMaxAge(604800);
        cookieLocaleResolver.setDefaultLocale(new Locale("en_US"));
        cookieLocaleResolver.setCookieName("resource");
        return cookieLocaleResolver;
    }
}
