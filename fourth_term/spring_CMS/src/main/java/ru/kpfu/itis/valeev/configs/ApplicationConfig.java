package ru.kpfu.itis.valeev.configs;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import ru.kpfu.itis.valeev.models.Website;
import ru.kpfu.itis.valeev.repositories.UserRepository;
import ru.kpfu.itis.valeev.repositories.UserRepositoryJdbcTemplateImpl;
import ru.kpfu.itis.valeev.repositories.WebsiteRepository;
import ru.kpfu.itis.valeev.repositories.WebsiteRepositoryJdbcTemplateImpl;
import ru.kpfu.itis.valeev.services.UserService;
import ru.kpfu.itis.valeev.services.UserServiceImpl;
import ru.kpfu.itis.valeev.services.WebsiteService;
import ru.kpfu.itis.valeev.services.WebsiteServiceImpl;

import javax.sql.DataSource;


@Configuration
@EnableWebMvc
@PropertySource("classpath:db.properties")

//Todo можно ли сканить все пакеты сразу для поиска всех бинов?
//Можно все добавить и исключить сами конфиги

@ComponentScan("ru.kpfu.itis.valeev.controllers")
public class ApplicationConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryJdbcTemplateImpl(dataSource());
    }

    @Bean
    public WebsiteService websiteService() {
        return new WebsiteServiceImpl(websiteRepository());
    }

    @Bean
    public WebsiteRepository websiteRepository() {
        return new WebsiteRepositoryJdbcTemplateImpl(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getProperty("db.hikari.max-pool-size")));
        hikariConfig.setUsername(environment.getProperty("db.username"));
        hikariConfig.setPassword(environment.getProperty("db.password"));
        hikariConfig.setDriverClassName(environment.getProperty("db.driver.classname"));
        return hikariConfig;
    }

//    @Bean
//    public FreeMarkerViewResolver freemarkerViewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftlh");
//        resolver.setContentType("text/html;charset=UTF-8");
//        return resolver;
//    }
//
//    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() {
//        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//        configurer.setTemplateLoaderPath("/WEB-INF/ftl/");
//        return configurer;
//    }

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setRedirectContextRelative(false);
        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("tests");
    }
}
