package com.medcare.backend.Service;

import com.medcare.backend.Model.Patient;
import com.medcare.backend.Model.Payment;
import com.medcare.backend.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public Payment register(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment>getAllPayments(){
        return paymentRepository.findAll();

    }

}
