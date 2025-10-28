package com.ecommerce.ecommerce.orderline;

import jakarta.validation.constraints.Positive;

public record OrderLineRequest(
                               Integer id,
                               Integer orderId,
                               Integer productId,
                               @Positive(message = "Quantity must be positive")
                               double quantity
) {
}
