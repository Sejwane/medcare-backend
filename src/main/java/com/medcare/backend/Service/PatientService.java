package com.medcare.backend.Service;

import com.medcare.backend.Model.Patient;
import com.medcare.backend.Repository.PatientRepository;
import com.medcare.backend.DTO.PatientUpdateDTO;
import com.medcare.backend.DTO.PatientCreateDTO; 

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    @Transactional
    public void restorePatient(Integer id) {
        patientRepository.restorePatient(id);
    }

    
    public Patient register(PatientCreateDTO createDTO) {
        
        Patient patient = new Patient();
        
        patient.setFirstName(createDTO.getFirstName());
        patient.setLastName(createDTO.getLastName());
        
        
        patient.setIdentificationType(createDTO.getIdentificationType().name()); 
        patient.setIdNumber(createDTO.getIdNumber());
        
        patient.setPhone(createDTO.getPhone());
        patient.setEmail(createDTO.getEmail());
        patient.setDateOfBirth(createDTO.getDateOfBirth());

        return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    
    @Transactional
    public Optional<Patient> patientUpdate(Integer id, PatientUpdateDTO updateDTO){
        return patientRepository.findById(id).map(
            patient -> {
                
                if (updateDTO.getFirstName() != null) {
                    patient.setFirstName(updateDTO.getFirstName());
                }
                if (updateDTO.getLastName() != null) {
                    patient.setLastName(updateDTO.getLastName());
                }
                if (updateDTO.getEmail() != null) {
                    patient.setEmail(updateDTO.getEmail());
                }
                if (updateDTO.getPhone() != null) {
                    patient.setPhone(updateDTO.getPhone());
                }
                
                return patientRepository.save(patient);
            }
        );
    }
}