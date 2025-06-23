package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders(OrderStatus status){
        List<Order> orders = orderRepository.getOrders(status);
        if(orders.isEmpty()){
            throw new ResourceNotFoundException("order list is empty");
        }else{
            return orders;
        }
    }
    public void placeOrder(Order order){
        orderRepository.placeOrder(order);
    }
    public Optional<Order> getOrderById(UUID id){
        return orderRepository.getOrderById(id);
    }
    public void updateOrderStatus(){
        orderRepository.updatePendingOrdersToProcessing();
    }
    public void updateStatus(UUID id,OrderStatus status){
        orderRepository.updateStatus(id,status);
    }
}