package com.viinidev.productservice.domain;

import java.math.BigDecimal;

public class Product {
    private final Long id;
    private final String name;
    private final BigDecimal price;
    private int stock;

    public Product(Long id, String name, BigDecimal price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getStock() { return stock; }

    public void reserve(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }
        if (stock < quantity) {
            throw new IllegalStateException("Insufficient stock.");
        }
        stock -= quantity;
    }
}
