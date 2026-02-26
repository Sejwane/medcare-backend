package com.medcare.backend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.Invoice;
import com.medcare.backend.Service.InvoiceService;

@RestController
@RequestMapping("api/invoices")
@CrossOrigin(origins="*")

public class InvoiceController {

@Autowired
private InvoiceService invoiceService;

@PostMapping("/add")
public Invoice register(@RequestBody Invoice invoice) {
    
    return invoiceService.register(invoice);
}

}
