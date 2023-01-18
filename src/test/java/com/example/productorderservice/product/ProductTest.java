package com.example.productorderservice.product;

import com.example.productorderservice.product.domain.DiscountPolicy;
import com.example.productorderservice.product.domain.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductTest {

    @Test
    void update() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);
    }


    @Test
    void none_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        final int discountedPrice = product.getDiscountedPrice();

        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void fix_1000_discounted_product() {
        final Product product = new Product("상품명", 1000, DiscountPolicy.FIX_1000_AMOUNT);

        final int discountedPrice = product.getDiscountedPrice();

        assertThat(discountedPrice).isEqualTo(0);
    }


}