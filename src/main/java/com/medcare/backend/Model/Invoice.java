package com.medcare.backend.Model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="invoices")

public class Invoice {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

    @Column(name="amount")
    private Double amount;

    @Column(name="payment_status")
    private String paymentStatus;

    @Column(name="invoice_date")
    private LocalDate invoiceDate;

    public Invoice(){}

    public Invoice(Appointment appointment,
            Double amount,
            String paymentStatus,
            LocalDate invoiceDate){
            this.appointment=appointment;
            this.amount=amount;
            this.paymentStatus=paymentStatus;
            this.invoiceDate=invoiceDate;
    }


    public Integer getId(){
        return id;
    }

    public Appointment getAppointment(){
        return appointment;
    }

    public Double getAmount(){
        return amount;
    }

    public String getPaymentStatus(){
        return paymentStatus;
    }

    public LocalDate getInvoiceDate(){
        return invoiceDate;
    }



    //Setters
    public void setId(Integer id){
        this.id=id;
    }

    public void setAppointment(Appointment appointment){
        this.appointment=appointment;
    }

    public void setAmount(Double amount){
        this.amount=amount;
    }
    
    public void setPaymentStatus(String paymentStatus){
        this.paymentStatus=paymentStatus;
    }

    public void setInvoiceDate(LocalDate invoiceDate){
        this.invoiceDate=invoiceDate;
    }

    }

