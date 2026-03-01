package com.medcare.backend.Service;

import com.medcare.backend.Model.MedicalRecord;
import com.medcare.backend.Repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service


public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;
    public MedicalRecord register(MedicalRecord medicalRecord){
        return  medicalRecordRepository.save(medicalRecord);
    }

    public List<MedicalRecord>getAllMedicalRecords(){
        return medicalRecordRepository.findAll();

    }

}
