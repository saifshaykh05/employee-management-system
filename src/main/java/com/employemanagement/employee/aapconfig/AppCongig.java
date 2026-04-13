package com.employemanagement.employee.aapconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppCongig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
