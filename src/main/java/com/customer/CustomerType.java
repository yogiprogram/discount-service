package com.customer;

public enum CustomerType {

    PREMIUM("PREMIUM"),
    REGULAR("REGULAR");

    private String customerType;

    CustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerType() {
        return this.customerType;
    }
}
