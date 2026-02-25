package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.Patient;
import com.medcare.backend.Service.PatientService;

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
}


