package com.example.demo.model;

import java.util.UUID;

public class Payment {
    private Long id;           // Id (SK)(PK) – Primary Key
    private Double amount;     // Amount
    private String paymentType; // paymentType
    private UUID orderId;      // orderId (FK) – Foreign Key
    private String refId;       // Ref_id
    private String CreatedAt; // created_At
    public Payment(Double amount, String paymentType, UUID orderId) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.orderId = orderId;
    }
    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
