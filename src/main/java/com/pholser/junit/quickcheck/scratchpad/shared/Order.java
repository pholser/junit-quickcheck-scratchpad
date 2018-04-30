package com.pholser.junit.quickcheck.scratchpad.shared;

public class Order {
    private final String id;
    private final String customerId;

    public Order(String id, String customerId) {
        this.id = id;
        this.customerId = customerId;
    }
}
