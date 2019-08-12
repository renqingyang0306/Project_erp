package com.rqy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 任清阳
 * @Email 1277409109@qq.com
 * @date 2019/8/6 20:48
 */
@Configuration
@ComponentScan(value = "com.rqy",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}))
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class SpringConfig {

    //dataSource
    @Bean
    public DataSource druidDatasource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/production_ssm?characterEncoding=utf8");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("12345678");
        return druidDataSource;
    }

    //SqlSessionFactoryBean
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //分页 以下
        PageInterceptor pageInterceptor = new PageInterceptor();
        //创建插件需要的参数集合
                Properties properties = new Properties();
        //配置数据库方言 为oracle
                properties.setProperty("helperDialect", "mysql");
        //配置分页的合理化数据
                properties.setProperty("reasonable", "true");
                pageInterceptor.setProperties(properties);
        //将拦截器设置到sqlSessionFactroy中
                sqlSessionFactoryBean.setPlugins(new Interceptor[] {pageInterceptor});
        //以上
        return sqlSessionFactoryBean;
    }
    //MapperScannerConfigurer
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer =new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.rqy.mapper");
        return mapperScannerConfigurer;
    }
    //文件的上传的配置
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setMaxInMemorySize(5240000);
        return commonsMultipartResolver;
    }
    //配置事务管理器，同时要开启注解
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
