package com.example.demo.component;

import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class OrderStatusScheduler {
    private final OrderService orderService;
    @Autowired
    public OrderStatusScheduler(OrderService orderService) {
        this.orderService = orderService;
    }
    @Scheduled(fixedRate = 300000) // runs every 5 minutes
    public void updatePendingOrders() {
        orderService.updateOrderStatus();
    }

}