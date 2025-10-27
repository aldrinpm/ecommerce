package com.ecommerce.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name cannot be null")
        String name,
        @NotNull(message = "Product description cannot be null")
        String description,
        @Positive(message = "Available quantity must be positive")
        double availableQuantity,
        @Positive(message = "Price must be positive")
        BigDecimal price,
        @NotNull(message = "Category ID cannot be null")
        Integer categoryId
) {
}
