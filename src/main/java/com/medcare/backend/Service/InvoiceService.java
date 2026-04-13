package com.medcare.backend.Service;

import com.medcare.backend.DTO.InvoiceDTO;
import com.medcare.backend.Model.Invoice;
import com.medcare.backend.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InvoiceService {
    @Autowired 
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(InvoiceDTO dto){
        Invoice invoice=new Invoice();

        invoice.setAmount(dto.getAmount());
        invoice.setPaymentStatus(dto.getPaymentStatus());
        //Date//

        return invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(Integer id,InvoiceDTO dto){
        Invoice existingInvoice=invoiceRepository.findById(id).orElseThrow();

        if (dto.getAmount() != null){
            dto.setAmount(dto.getAmount());
        }

        if (dto.getPaymentStatus() != null){
            dto.setPaymentStatus(dto.getPaymentStatus());
        }

        return invoiceRepository.save(existingInvoice);
    }



    public List<Invoice>getAllInvoices(){
        return invoiceRepository.findAll();
    }

}
