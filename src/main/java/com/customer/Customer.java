package com.customer;

public class Customer {

    private CustomerType customerType;
    private double amount;

    public Customer(CustomerType customerType, double amount) {
        this.customerType = customerType;
        this.amount = amount;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public double getAmount() {
        return amount;
    }
}
