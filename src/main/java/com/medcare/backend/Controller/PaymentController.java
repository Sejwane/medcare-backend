package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.Invoice;
import com.medcare.backend.Model.Payment;
import com.medcare.backend.Service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("api/payments")
@CrossOrigin(origins="*")

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public Payment register(@RequestBody Payment payment) {
        
        
        return paymentService.register(payment);
    }

    @GetMapping("/all")
    public List<Payment>getAllPayments() {
        return paymentService.getAllPayments();
    }
    

}
