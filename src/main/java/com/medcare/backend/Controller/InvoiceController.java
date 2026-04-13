package com.medcare.backend.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medcare.backend.DTO.InvoiceDTO;

import com.medcare.backend.Model.Invoice;
import com.medcare.backend.Service.InvoiceService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
@CrossOrigin(origins="*")

public class InvoiceController {

@Autowired
private InvoiceService invoiceService;

@PostMapping("/add")
public ResponseEntity<Invoice> createInvoice(@Valid @RequestBody InvoiceDTO dto){
    Invoice newInvoice = invoiceService.createInvoice(dto);
    return ResponseEntity.ok(newInvoice);
}

@PatchMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Integer id, @Valid @RequestBody InvoiceDTO dto) {
        try {
            Invoice updatedInvoice = invoiceService.updateInvoice(id, dto);
            return ResponseEntity.ok(updatedInvoice);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

@GetMapping("/all")
public List<Invoice>getAllInvoices() {
    return invoiceService.getAllInvoices();
}

}
