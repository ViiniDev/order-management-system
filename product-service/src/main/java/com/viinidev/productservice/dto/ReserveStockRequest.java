package com.viinidev.productservice.dto;

import jakarta.validation.constraints.Min;

public record ReserveStockRequest(@Min(1) int quantity) {
}
