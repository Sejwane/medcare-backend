package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.medcare.backend.Model.Patient;
import com.medcare.backend.Service.PatientService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.medcare.backend.DTO.PatientUpdateDTO;

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

    @PatchMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer id,
        @Valid @RequestBody PatientUpdateDTO updateDTO) {
            try {
                Optional<Patient> updatedPatient=patientService.patientUpdate(id, updateDTO);

                if (updatedPatient.isPresent()){
                    return ResponseEntity.ok(updatedPatient.get());
                } else {
                     return ResponseEntity.status(404).build();

                }
                
            } catch(IllegalArgumentException e) {
                return ResponseEntity.badRequest().build();

            }
        }
    
}


