package com.example.demo.repository;

import com.example.demo.model.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentDao {
    public List<Payment> getPayments(UUID id);
}
