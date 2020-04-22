package com.customer;

import com.service.DiscountService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountCustomerPremiumTest {

    private DiscountService discountService;

    @Before
    public void init() {
        discountService = new DiscountService();
    }

    @Test
    public void test_TenPercent_Discount_success() {
        assertEquals(3600,
                discountService.calculate(new Customer(CustomerType.PREMIUM, 4000)), 1);
    }

    @Test
    public void test_FifteenPercentDiscount_success() {
        assertEquals(7000,
                discountService.calculate(new Customer(CustomerType.PREMIUM, 8000)), 1);
    }

    @Test
    public void test_TweetyPercentDiscount_success() {
        assertEquals(10200,
                discountService.calculate(new Customer(CustomerType.PREMIUM, 12000)), 1);
    }

    @Test
    public void test_ThirtyPercentDiscount_success2() {
        assertEquals(15800,
                discountService.calculate(new Customer(CustomerType.PREMIUM, 20000)), 1);
    }
}
