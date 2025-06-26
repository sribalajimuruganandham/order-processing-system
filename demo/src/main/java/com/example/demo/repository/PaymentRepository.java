package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaymentRepository implements PaymentDao {
    public static List<Payment> PaymentDB = new ArrayList<>();
    public List<Payment> getPayments(UUID id){
        return PaymentDB.stream()
                .filter(payment -> id.equals(payment.getOrderId()))
                .toList();
    }

}
