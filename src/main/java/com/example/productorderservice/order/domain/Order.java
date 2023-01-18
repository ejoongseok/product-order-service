package com.example.productorderservice.order.domain;

import com.example.productorderservice.product.domain.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private int quantity;

    public Order(final Product product, final int quantity) {
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return product.getDiscountedPrice() * quantity;
    }
}
