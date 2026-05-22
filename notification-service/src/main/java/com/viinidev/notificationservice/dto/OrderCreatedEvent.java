package com.viinidev.notificationservice.dto;

public record OrderCreatedEvent(Long orderId, String customerEmail, String productName, int quantity) {
}
