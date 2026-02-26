package com.medcare.backend.Repository;

import com.medcare.backend.Model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Integer>{

}
