package com.example.demo.repository;

import com.example.demo.exception.OrderStatusConflictException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderRepository implements OrderDao{
    public static List<Order> DB = new ArrayList<>();
    public List<Order> getOrders(OrderStatus status){
        if(status != null) {
            return DB.stream().filter(
                    order -> order.getStatus().equals(status)
            ).toList();
        }
        return DB;
    }
    public void placeOrder(Order order){
        DB.add(order);
    }
    public Optional<Order> getOrderById(UUID id){
        return Optional.ofNullable(DB.stream().filter(
                order -> order.getId().equals(id)
        ).findFirst().orElseThrow(() -> new ResourceNotFoundException("Order not found")));
    }
    public void updatePendingOrdersToProcessing(){
        for (Order order : DB) {
            if (OrderStatus.PENDING.equals(order.getStatus())) {
                order.setStatus(OrderStatus.PROCESSING);
            }
        }
        System.out.println(DB);
    }
    public void updateStatus(UUID id,OrderStatus status) {
        Optional<Order> orderData = Optional.ofNullable(DB.stream()
                .filter(order -> order.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResourceNotFoundException("Order not found")));
        if (orderData.isPresent()) {
            Order orderDetails = orderData.get();
            if(status != OrderStatus.CANCELLED){
                orderDetails.setStatus(status);
            }
            else if (orderDetails.getStatus() == OrderStatus.PENDING) {
                orderDetails.setStatus(status);
            }else{
                throw new OrderStatusConflictException("Order status can't be change");
            }
        }
    }

}
