package com.epam.rd.july2019.spring_internet_provider.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.Resource;
import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy(proxyTargetClass = true)
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages= {
        "com.epam.rd.july2019.spring_internet_provider.controller",
        "com.epam.rd.july2019.spring_internet_provider.service",
        "com.epam.rd.july2019.spring_internet_provider.converter",
        "com.epam.rd.july2019.spring_internet_provider.validator",
        "com.epam.rd.july2019.spring_internet_provider.aspects",
        "com.epam.rd.july2019.spring_internet_provider.dao"})

public class WebConfig implements WebMvcConfigurer {

    private static final String PROP_DATABASE_DRIVER = "db.driver";
    private static final String PROP_DATABASE_PASSWORD = "db.password";
    private static final String PROP_DATABASE_URL = "db.url";
    private static final String PROP_DATABASE_USERNAME = "db.user";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSourceMariaDb() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getRequiredProperty(PROP_DATABASE_DRIVER));
        dataSource.setUrl(env.getRequiredProperty(PROP_DATABASE_URL));
        dataSource.setUsername(env.getRequiredProperty(PROP_DATABASE_USERNAME));
        dataSource.setPassword(env.getRequiredProperty(PROP_DATABASE_PASSWORD));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSourceMariaDb());
    }

    @Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSourceMariaDb());
    }

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("message_en");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(100000);
        return multipartResolver;
    }


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

}
