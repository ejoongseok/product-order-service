package com.example.productorderservice.order.application.service;

import org.springframework.util.Assert;

public record CreateOrderRequest(Long productId, int quantity) {
    public CreateOrderRequest {
        Assert.notNull(productId, "상품 ID는 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }

}
