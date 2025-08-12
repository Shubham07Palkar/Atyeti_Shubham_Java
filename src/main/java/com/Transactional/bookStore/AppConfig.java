package com.Transactional.bookStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

    @Bean
    @Profile("dev")
    public String devBean(){
        return "This is the Dev Bean";
    }

    @Bean
    @Profile("test")
    public String testBean(){
        return "This is the Test Bean";
    }

    @Bean
    @Profile("Prod")
    public String prodBean(){
        return "This is the Prod Bean";
    }

}
