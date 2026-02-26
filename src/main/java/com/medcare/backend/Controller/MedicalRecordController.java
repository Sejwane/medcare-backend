package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.MedicalRecord;
import com.medcare.backend.Service.MedicalRecordService;

@RestController
@RequestMapping("/api/medical_records")
@CrossOrigin(origins = "*") 

public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping("/register")
    public MedicalRecord register(@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.register(medicalRecord);
    }
    
}
