package com.viinidev.orderservice.domain;

import java.time.LocalDateTime;

public class Order {
    private final Long id;
    private final Long productId;
    private final String productName;
    private final String customerEmail;
    private final int quantity;
    private final LocalDateTime createdAt;

    public Order(Long id, Long productId, String productName, String customerEmail, int quantity) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.customerEmail = customerEmail;
        this.quantity = quantity;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public Long getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCustomerEmail() { return customerEmail; }
    public int getQuantity() { return quantity; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
