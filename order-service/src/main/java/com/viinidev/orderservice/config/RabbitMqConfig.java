package com.viinidev.orderservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    DirectExchange ordersExchange(@Value("${app.rabbitmq.exchange}") String exchange) {
        return new DirectExchange(exchange);
    }

    @Bean
    Queue ordersQueue(@Value("${app.rabbitmq.queue}") String queue) {
        return QueueBuilder.durable(queue).build();
    }

    @Bean
    Binding ordersBinding(Queue ordersQueue, DirectExchange ordersExchange, @Value("${app.rabbitmq.routing-key}") String routingKey) {
        return BindingBuilder.bind(ordersQueue).to(ordersExchange).with(routingKey);
    }

    @Bean
    Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
