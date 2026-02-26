package com.medcare.backend.Repository;

import com.medcare.backend.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface InvoiceRepository extends JpaRepository<Invoice,Integer>{

}
