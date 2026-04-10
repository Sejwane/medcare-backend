package com.medcare.backend.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import com.medcare.backend.DTO.PatientCreateDTO;

public class IdentificationValidator implements ConstraintValidator<ValidIdentification, PatientCreateDTO> {

    @Override
    public boolean isValid(PatientCreateDTO dto, ConstraintValidatorContext context) {

        if (dto == null) return true;

        if (dto.getIdentificationType() == null || dto.getIdNumber() == null) {
            return false;
        }

        if (dto.getIdentificationType() == PatientCreateDTO.IdentificationType.SA_ID) {
            return dto.getIdNumber().matches("\\d{13}");
        }

        if (dto.getIdentificationType() == PatientCreateDTO.IdentificationType.PASSPORT) {
            return dto.getIdNumber().matches("[a-zA-Z0-9]+");
        }

        return false;
    }
}