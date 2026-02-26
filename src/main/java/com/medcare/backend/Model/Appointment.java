package com.medcare.backend.Model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat; 



@Entity
@Table(name="appointments")

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /*
    Now the DepartmentID,PatientID and The DoctorId
    are all from tables departments,patients,and users
    */
    
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

   
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private User doctor;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name="appointment_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate appointmentDate;

    @Column(name="appointment_time")
    @JsonFormat(pattern="HH:mm:ss") 
    private LocalTime appointmentTime; 

    @Column(name="status")
    private String status;


    public Appointment(){ }

    public Appointment(
        
        Patient patient,
        User doctor,
        Department department,
        LocalDate appointmentDate,
        LocalTime appointmentTime, 
        String status){

            this.patient=patient;
            this.doctor=doctor;
            this.department=department;
            this.appointmentDate=appointmentDate;
            this.appointmentTime=appointmentTime;
            this.status=status;

    }
    //getters

    public Integer getId(){
        return id;
    }

    public Patient getPatient(){
        return patient;
    }

    public User getDoctor(){
        return doctor;
    }

    public Department getDepartment(){
        return department;
    }

    public LocalDate getAppointmentDate(){
        return appointmentDate;
    }

    public LocalTime getAppointmentTime(){
        return appointmentTime;
    }

    public String getStatus(){
        return  status;
    }

    //setters

    public void setId(Integer id){
        this.id=id;

    }

    public void setPatient(Patient patient){
        this.patient=patient;
    }

    public void setDoctor(User doctor){
        this.doctor=doctor;

    }

    public void setAppointmentDate(LocalDate appointmentDate){
        this.appointmentDate=appointmentDate;
    }
    public void setAppointmentTime(LocalTime appointmentTime){
        this.appointmentTime=appointmentTime;
    }
    public void setStatus(String status){
        this.status=status;
    }
   

 

}
