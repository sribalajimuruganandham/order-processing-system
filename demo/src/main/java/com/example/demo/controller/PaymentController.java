package com.example.demo.controller;

import com.example.demo.model.Payment;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequestMapping("api/v1/order")
@RestController
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(path="{id}/payment")
    public ResponseEntity<ApiResponse> getPaymentList(@PathVariable("id") UUID orderId) {
        List<Payment> paymentList = paymentService.getPayments(orderId);
        return ResponseEntity.ok(new ApiResponse("success", paymentList));
    }
    }