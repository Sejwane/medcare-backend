package com.medcare.backend.DTO;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class InvoiceDTO {

    @Positive(message="Amount Should Be Positive")
    private Double amount;

    @Size(max=20,message="Status cant be too long")
    private String paymentStatus;

    
    public InvoiceDTO() {
    }

   
    public InvoiceDTO(Double amount, String paymentStatus) {
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

  
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}