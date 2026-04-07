package com.medcare.backend.Service;

import com.medcare.backend.Model.Patient;
import com.medcare.backend.Repository.PatientRepository;
import com.medcare.backend.DTO.PatientUpdateDTO;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import jakarta.transaction.Transactional;


@Service 
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient register(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient>getAllPatients(){
        return patientRepository.findAll();
    }


    @Transactional
    public Optional<Patient> patientUpdate(Integer id,PatientUpdateDTO updateDTO){
        return patientRepository.findById(id).map(
            patient -> {
                patient.setFirstName(updateDTO.getFirstName());
                patient.setLastName(updateDTO.getLastName());
                patient.setEmail(updateDTO.getEmail());
                patient.setPhone(updateDTO.getPhone());
                return patientRepository.save(patient);
            }

        );
  
    }
   
}

