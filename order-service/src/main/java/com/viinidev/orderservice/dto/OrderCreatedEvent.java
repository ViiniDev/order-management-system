package com.viinidev.orderservice.dto;

public record OrderCreatedEvent(Long orderId, String customerEmail, String productName, int quantity) {
}
