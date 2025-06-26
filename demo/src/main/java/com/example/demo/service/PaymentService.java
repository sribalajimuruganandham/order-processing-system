package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Payment;
import com.example.demo.repository.PaymentRepository;

import java.util.List;
import java.util.UUID;

public class PaymentService {
    PaymentRepository paymentRepository;
    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }
    public List<Payment> getPayments(UUID id){
        List<Payment> paymentList = paymentRepository.getPayments(id);
        if(paymentList.isEmpty()){
            throw new ResourceNotFoundException("no payment was made yet");
        }else{
            return paymentList;
        }
    }
}
