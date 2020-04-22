package com.service;

import com.customer.Customer;
import com.discount.Discount;
import com.discount.Slab;

import java.util.List;

public class DiscountService {

    private Discount discount;

    public DiscountService() {
        discount = Discount.getInstance();
    }

    public double calculate(Customer customer) {
        List<Slab> slabs = discount.getDiscounts().get(customer.getCustomerType().getCustomerType());
        double discountAmount = 0;
        double remainingAmount = customer.getAmount();
        for (Slab slab : slabs) {
            if (remainingAmount > 0) {
                double calculate = slab.calculate(remainingAmount);
                discountAmount += calculate;
                remainingAmount = slab.getRemainingAmount(remainingAmount);
            }
        }
        return customer.getAmount() - discountAmount;
    }

}
