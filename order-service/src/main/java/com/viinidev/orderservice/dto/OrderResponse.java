package com.viinidev.orderservice.dto;

import com.viinidev.orderservice.domain.Order;

import java.time.LocalDateTime;

public record OrderResponse(
        Long id,
        Long productId,
        String productName,
        String customerEmail,
        int quantity,
        LocalDateTime createdAt
) {
    public static OrderResponse from(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getProductId(),
                order.getProductName(),
                order.getCustomerEmail(),
                order.getQuantity(),
                order.getCreatedAt()
        );
    }
}
