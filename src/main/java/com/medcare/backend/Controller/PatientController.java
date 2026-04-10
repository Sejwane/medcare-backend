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

import com.medcare.backend.DTO.PatientCreateDTO;
import com.medcare.backend.DTO.PatientUpdateDTO;

@RestController
@RequestMapping("api/patients")
@CrossOrigin(origins="*")
public class PatientController {

    @Autowired
    private PatientService patientService;

   @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody PatientCreateDTO createDTO){
        
        // The Service layer will now take the secure DTO, convert it into a Patient Entity, and save it.
        try {
            Patient newPatient = patientService.register(createDTO);
            return ResponseEntity.ok(newPatient);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error registering patient: " + e.getMessage());
        }
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


