package com.medcare.backend.DTO;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class DepartmentDTO {
    @NotBlank(message="Department name is required")
    @Size(max=100,message="Department name is too long")
    private String name;

    @PositiveOrZero(message="Consultation fee should be greater than zero")
    private double consultationFee;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Double getConsultationFee(){
        return consultationFee;
    }

    public void getConsultationFee(Double consultationFee){
        this.consultationFee=consultationFee;
    }

    public DepartmentDTO(Integer id, String name, Double consultationFee) {
       
        this.name = name;
        this.consultationFee = consultationFee;
    }

}
