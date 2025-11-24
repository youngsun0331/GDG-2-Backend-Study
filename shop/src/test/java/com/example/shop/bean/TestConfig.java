package com.example.shop.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    MyBean myBean(){
        return new MyBean();
    }
}
