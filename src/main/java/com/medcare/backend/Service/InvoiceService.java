package com.medcare.backend.Service;


import com.medcare.backend.Model.Invoice;
import com.medcare.backend.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InvoiceService {
    @Autowired 
    private InvoiceRepository invoiceRepository;

    public Invoice register(Invoice invoice){
        return invoiceRepository.save(invoice);

    }

    public List<Invoice>getAllInvoices(){
        return invoiceRepository.findAll();
    }

}
