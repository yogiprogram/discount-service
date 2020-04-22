package com.discount;

import java.util.ArrayList;
import java.util.List;

public class Slab {
    private double start;
    private double end;
    private boolean above;
    private double discountPercent;

    public static Slab build() {
        return new Slab();
    }

    public static List<Slab> buildPremiumCustomerSlab() {
        List<Slab> slabs = new ArrayList<>();
        slabs.add(Slab.build().start(0).end(4000).discountPercent(10));
        slabs.add(Slab.build().start(4000).end(8000).discountPercent(15));
        slabs.add(Slab.build().start(8000).end(12000).discountPercent(20));
        slabs.add(Slab.build().start(12000).above(true).discountPercent(30));
        return slabs;
    }

    public static List<Slab> buildRegularCustomerSlab() {
        List<Slab> slabs = new ArrayList<>();
        slabs.add(Slab.build().start(0).end(5000).discountPercent(0));
        slabs.add(Slab.build().start(5000).end(10000).discountPercent(10));
        slabs.add(Slab.build().start(10000).above(true).discountPercent(20));
        return slabs;
    }

    public Slab start(double start) {
        this.start = start;
        return this;
    }

    public Slab end(double end) {
        this.end = end;
        return this;
    }

    public Slab discountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
        return this;
    }

    public Slab above(boolean above) {
        this.above = above;
        return this;
    }

    public double calculate(double totalAmount) {
        double discountOnAmount = totalAmount;
        if (!isAbove() && totalAmount >= getSlabDifferenceTotalAmount()) {
            discountOnAmount = getSlabDifferenceTotalAmount();
        }
        return (discountOnAmount / 100) * this.discountPercent;
    }

    public double getRemainingAmount(double remainingAmount) {
        if (isAbove()) {
            remainingAmount = -1;
        } else if (remainingAmount >= getSlabDifferenceTotalAmount()) {
            remainingAmount = remainingAmount - getSlabDifferenceTotalAmount();
        } else {
            remainingAmount = remainingAmount - getEnd();
        }
        return remainingAmount;
    }

    private double getSlabDifferenceTotalAmount() {
        return getEnd() - getStart();
    }

    public double getEnd() {
        return end;
    }

    public double getStart() {
        return start;
    }

    public boolean isAbove() {
        return above;
    }
}
