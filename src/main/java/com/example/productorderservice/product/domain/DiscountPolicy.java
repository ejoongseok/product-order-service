package com.example.productorderservice.product.domain;

public enum DiscountPolicy {
    NONE {
        @Override
        public int applyDiscount(final int price) {
            return price;
        }
    },
    FIX_1000_AMOUNT {
        @Override
        public int applyDiscount(final int price) {
            return Math.max(price - 1000, 0);
        }
    };

    public abstract int applyDiscount(final int price);
}
