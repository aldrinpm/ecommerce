package com.ecommerce.ecommerce.product;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product ID cannot be null")
        Integer productId,
        @NotNull(message = "Quantity cannot be null")
        double quantity
) {
}
