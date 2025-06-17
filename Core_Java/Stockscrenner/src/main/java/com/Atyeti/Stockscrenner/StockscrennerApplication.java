package com.Atyeti.Stockscrenner;

import com.Atyeti.Stockscrenner.entity.Stock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StockscrennerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockscrennerApplication.class, args);
	}

	@Configuration
	public class RestTemplateConfig{
		@Bean
		public RestTemplate restTemplate(){
			return new RestTemplate();
		}
	}
}
