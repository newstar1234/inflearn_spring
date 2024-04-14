package com.example.productorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DiscountPolicyTest {
    @Test
    void noneDiscountPolicy() {
        final int price = 1000;

        final int discountedPrice = DiscountPolicy.NONE.applyDiscount(1000);

        assertThat(discountedPrice).isEqualTo(price);
    }  

    @Test
    void fix_1000_discount_price() {
        final int price = 2000;

        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(1000);

    } 

    @Test
    void over_discounted_price() {
        final int price = 500;

        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(0);

    } 
}
