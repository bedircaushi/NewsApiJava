package com.example.news.service.config;

import com.example.news.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAutoConfiguration {
    @Bean
    public CarService carService(){
        return new DefaultCarService();
    }

    @Bean
    public AdminService adminService(){
        return new DefaultAdminService();
    }

    @Bean
    public NewsService newsService(){
        return new DefaultNewsService();
    }
}
