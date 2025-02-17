package com.fdmgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication(scanBasePackages="com.fdmgroup")
public class AccountAndCustomerManagementApplication{
	
	private final String GEOCODER_API_URL = "https://geocoder.ca"; 

	public static void main(String[] args) {
		SpringApplication.run(AccountAndCustomerManagementApplication.class, args);
	}
	
	@Bean
	WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

    @Bean
    WebClient customerWebClient(WebClient.Builder builder) {
		return builder.baseUrl(GEOCODER_API_URL).defaultHeader(HttpHeaders.CONTENT_TYPE, 
				MediaType.APPLICATION_JSON_VALUE).build();
	}
	
}