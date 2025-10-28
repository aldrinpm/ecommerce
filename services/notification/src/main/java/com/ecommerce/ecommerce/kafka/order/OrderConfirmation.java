package com.ecommerce.ecommerce.kafka.order;

import com.ecommerce.ecommerce.kafka.payment.PaymentMethod;
import org.bouncycastle.pqc.legacy.math.ntru.polynomial.ProductFormPolynomial;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
