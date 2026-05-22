package com.viinidev.orderservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    WebClient productWebClient(@Value("${app.product-service-url}") String productServiceUrl) {
        return WebClient.builder().baseUrl(productServiceUrl).build();
    }
}
