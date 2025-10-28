package com.ecommerce.ecommerce.payment;

import com.ecommerce.ecommerce.customer.CustomerResponse;
import com.ecommerce.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
