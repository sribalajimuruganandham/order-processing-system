package com.example.demo.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    @NotNull(message = "Total Price must not be null")
    @Positive(message = "Total Price must be greater than zero")
    private double totalPrice;
    private List<@Valid Product> products = new ArrayList<>();
    private OrderStatus status;
    public Order(double totalPrice, List<Product> products) {
        this.id = UUID.randomUUID();
        this.totalPrice = totalPrice;
        this.products = products;
        this.status = OrderStatus.PENDING;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public UUID getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
