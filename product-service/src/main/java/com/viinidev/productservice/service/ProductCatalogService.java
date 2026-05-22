package com.viinidev.productservice.service;

import com.viinidev.productservice.domain.Product;
import com.viinidev.productservice.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductCatalogService {
    private final Map<Long, Product> products = new LinkedHashMap<>();

    public ProductCatalogService() {
        products.put(1L, new Product(1L, "Notebook Pro", BigDecimal.valueOf(4500), 10));
        products.put(2L, new Product(2L, "Mouse Wireless", BigDecimal.valueOf(120), 25));
        products.put(3L, new Product(3L, "Teclado Mecanico", BigDecimal.valueOf(320), 15));
    }

    public List<ProductResponse> list() {
        return products.values().stream().map(ProductResponse::from).toList();
    }

    public ProductResponse getById(Long id) {
        return ProductResponse.from(getEntity(id));
    }

    public ProductResponse reserve(Long id, int quantity) {
        Product product = getEntity(id);
        product.reserve(quantity);
        return ProductResponse.from(product);
    }

    private Product getEntity(Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new IllegalArgumentException("Product not found.");
        }
        return product;
    }
}
