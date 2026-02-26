package com.medcare.backend.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat; 

@Entity
@Table(name="medical_records")


public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctor_id")
    private User doctor;

    @Lob
    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @Column(name="record_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate recordDate;

    public MedicalRecord(){}//hibernate

    public MedicalRecord(Patient patient,User doctor,String notes,LocalDate recordDate){
        this.doctor=doctor;
        this.doctor=doctor;
        this.notes=notes;
        this.recordDate=recordDate;
    }

    //getters 

    public Integer getId(){
        return id;
    }

    public  User getDoctor(){
        return doctor;
    }

    public String getNotes(){
        return notes;
    }

    public LocalDate getRecordDate(){
        return recordDate;
    }

    //setters

    public void setId(Integer id){
        this.id=id;
    }

    public void setDoctor(User doctor){
        this.doctor=doctor;
    }

    public void setNotes(String notes){
        this.notes=notes;
    }

    public void setRecordDate(LocalDate recordDate){
        this.recordDate=recordDate;
    }

    

}
