package com.medcare.backend.Model;


import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="payments")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="invoice_id")
    private Invoice invoice;

    @Column(name="payment_method")
    private String paymentMethod;

    @Column(name="amount")
    private Double amount;

    @Column(name="payment_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate paymentDate;

    public Payment(){}

    public Payment(Invoice invoice,String paymentMethod,Double amount,LocalDate paymentDate){
        this.invoice=invoice;
        this.paymentMethod=paymentMethod;
        this.amount=amount;
        this.paymentDate=paymentDate;
    }

    public Integer getId(){
        return id;

    }

    public Invoice geInvoice(){
        return invoice;

    }

    public String getPaymentMethod(){
        return paymentMethod;
    }

    public Double getAmount(){
        return amount;
    }

    public LocalDate getPaymentDate(){
        return paymentDate;
    }
 

    public void setId(Integer id){
        this.id=id;
    }
    public void setInvoice(Invoice invoice){
        this.invoice=invoice;
    }

    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod=paymentMethod;
    }

    public void setAmount(Double amount){
        this.amount=amount;
    }

    public void setPaymentDate(LocalDate paymentDate){
        this.paymentDate=paymentDate;

    }
    
}
