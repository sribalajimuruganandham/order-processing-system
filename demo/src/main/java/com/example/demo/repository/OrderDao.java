package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderDao {
    List<Order> getOrders(OrderStatus status);
    Optional<Order> getOrderById(UUID id);
    void placeOrder(Order order);
    void updatePendingOrdersToProcessing();
    void updateStatus(UUID id,OrderStatus status);
}
