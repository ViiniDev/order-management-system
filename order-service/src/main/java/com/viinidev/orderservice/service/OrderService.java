package com.viinidev.orderservice.service;

import com.viinidev.orderservice.domain.Order;
import com.viinidev.orderservice.dto.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(1);
    private final WebClient productWebClient;
    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public OrderService(
            WebClient productWebClient,
            RabbitTemplate rabbitTemplate,
            @Value("${app.rabbitmq.exchange}") String exchange,
            @Value("${app.rabbitmq.routing-key}") String routingKey
    ) {
        this.productWebClient = productWebClient;
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public OrderResponse create(CreateOrderRequest request) {
        ProductResponse product = productWebClient.patch()
                .uri("/api/products/{id}/reserve", request.productId())
                .bodyValue(new ReserveStockRequest(request.quantity()))
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .block();

        if (product == null) {
            throw new IllegalStateException("Product service did not return a product.");
        }

        Order order = new Order(sequence.getAndIncrement(), product.id(), product.name(), request.customerEmail(), request.quantity());
        orders.add(order);
        rabbitTemplate.convertAndSend(exchange, routingKey, new OrderCreatedEvent(order.getId(), order.getCustomerEmail(), order.getProductName(), order.getQuantity()));
        return OrderResponse.from(order);
    }

    public List<OrderResponse> list() {
        return orders.stream().map(OrderResponse::from).toList();
    }
}
