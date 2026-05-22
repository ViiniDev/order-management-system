package com.viinidev.orderservice.dto;

import java.math.BigDecimal;

public record ProductResponse(Long id, String name, BigDecimal price, int stock) {
}
