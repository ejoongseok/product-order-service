package com.example.productorderservice.order.adapter;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.order.application.port.OrderPort;
import com.example.productorderservice.product.domain.Product;
import com.example.productorderservice.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(final ProductRepository productRepository, final OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
