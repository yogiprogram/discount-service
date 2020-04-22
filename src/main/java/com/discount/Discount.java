package com.discount;

import com.customer.CustomerType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Discount {

    private static Discount discount = new Discount();
    private Map<String, List<Slab>> discounts;

    public static Discount getInstance() {
        return discount;
    }

    public Map<String, List<Slab>> getDiscounts() {
        if (Objects.isNull(discounts)) {
            initializeDiscounts();
        }
        return new HashMap<>(discounts);
    }

    private void initializeDiscounts() {
        discounts = new HashMap<>();
        discounts.put(CustomerType.PREMIUM.getCustomerType(), Slab.buildPremiumCustomerSlab());
        discounts.put(CustomerType.REGULAR.getCustomerType(), Slab.buildRegularCustomerSlab());
    }
}
