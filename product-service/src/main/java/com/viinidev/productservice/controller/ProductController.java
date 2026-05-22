package com.viinidev.productservice.controller;

import com.viinidev.productservice.dto.ProductResponse;
import com.viinidev.productservice.dto.ReserveStockRequest;
import com.viinidev.productservice.service.ProductCatalogService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductCatalogService productCatalogService;

    public ProductController(ProductCatalogService productCatalogService) {
        this.productCatalogService = productCatalogService;
    }

    @GetMapping
    public List<ProductResponse> list() {
        return productCatalogService.list();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id) {
        return productCatalogService.getById(id);
    }

    @PatchMapping("/{id}/reserve")
    public ProductResponse reserve(@PathVariable Long id, @RequestBody @Valid ReserveStockRequest request) {
        return productCatalogService.reserve(id, request.quantity());
    }
}
