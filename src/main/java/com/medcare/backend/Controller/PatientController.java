package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.Invoice;
import com.medcare.backend.Model.Patient;
import com.medcare.backend.Service.PatientService;

import java.util.List;

@RestController
@RequestMapping("api/patients")
@CrossOrigin(origins="*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/register")
    public Patient register(@RequestBody Patient patient){
        return patientService.register(patient);
    }

    @GetMapping("/all")
    public List<Patient>getAllPatients() {
        return patientService.getAllPatients();
    }
}


