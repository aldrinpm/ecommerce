package com.ecommerce.ecommerce.order;

import com.ecommerce.ecommerce.customer.CustomerClient;
import com.ecommerce.ecommerce.exception.BusinessException;
import com.ecommerce.ecommerce.orderline.OrderLineRequest;
import com.ecommerce.ecommerce.orderline.OrderLineService;
import com.ecommerce.ecommerce.product.ProductClient;
import com.ecommerce.ecommerce.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;

    public Integer createOrder(@Valid OrderRequest orderRequest) {
        var customer = customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer found with id " + orderRequest.customerId()));

        this.productClient.purchaseProducts(orderRequest.products());

        var order = this.orderRepository.save(orderMapper.toOrder(orderRequest));

        for (PurchaseRequest purchaseRequest: orderRequest.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        return null;
    }
}
