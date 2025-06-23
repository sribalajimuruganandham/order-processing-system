package com.example.demo.controller;

import com.example.demo.DTO.UpdateStatusRequest;
import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/order")
@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getListOfOrders(@RequestParam(required = false) OrderStatus status) {
        List<Order> orders = orderService.getOrders(status);
        return ResponseEntity.ok(new ApiResponse("success", orders));
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable("id") UUID id) {
        Optional<Order> order = orderService.getOrderById(id);
        return ResponseEntity.ok(new ApiResponse("success", order));
    }

    @PatchMapping(path = "{id}/status")
    public ResponseEntity<ApiResponse> updateStatus(@PathVariable("id") UUID id, @RequestBody @Valid UpdateStatusRequest status) {
        orderService.updateStatus(id, status.getStatus());
        return ResponseEntity.ok(new ApiResponse("Order status updated", null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> placeOrder(@RequestBody @Valid Order order) {
        orderService.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse("Order Placed", null));
    }
}
