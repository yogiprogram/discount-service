package com.customer;

import com.service.DiscountService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountCustomerRegularTest {

    private DiscountService discountService;

    @Before
    public void init() {
        discountService = new DiscountService();
    }

    @Test
    public void test_NilPercent_Discount_success() {
        assertEquals(5000,
                discountService.calculate(new Customer(CustomerType.REGULAR, 5000)), 1);
    }

    @Test
    public void test_tenPercentDiscount_success() {
        assertEquals(9500,
                discountService.calculate(new Customer(CustomerType.REGULAR, 10000)), 1);
    }

    @Test
    public void test_tweetyPercentDiscount_success() {
        assertEquals(13500,
                discountService.calculate(new Customer(CustomerType.REGULAR, 15000)), 1);
    }
}
