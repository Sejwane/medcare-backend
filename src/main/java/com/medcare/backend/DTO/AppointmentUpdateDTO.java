package com.medcare.backend.DTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentUpdateDTO {


    @FutureOrPresent(message = "Appointment date cannot be in the past")
    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    @Pattern(regexp = "^(SCHEDULED|COMPLETED|CANCELLED)$", message = "Invalid status")
    private String status;


    public LocalDate getAppointmentDate(){
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate){
        this.appointmentDate = appointmentDate;
    }

    public LocalTime getAppointmentTime(){
        return appointmentTime;
    }

    public void setAppointmentTime(LocalTime appointmentTime){
        this.appointmentTime = appointmentTime;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }


}
