package com.medcare.backend.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonFormat; 

@Entity
@Table(name = "patients")

@SQLDelete(sql = "UPDATE patients SET is_deleted = true WHERE id=?")

@SQLRestriction("is_deleted = false")

public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "identification_type")
    private String identificationType;

    @Column(name="id_number")
    private String idNumber;

    @Column(name="phone")
    private String phone;

    @Column(unique = true)
    private String email;

    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    public Patient(){}

    public Patient(String firstName, String lastName,String idNumber,String phone,String email,LocalDate dateOfBirth){
        this.firstName=firstName;
        this.lastName=lastName;
        this.idNumber=idNumber;
        this.phone=phone;
        this.email=email;
        this.dateOfBirth=dateOfBirth;
    }

    //getters 

    public Integer getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getIdNumber(){
        return idNumber;
    }

    public String getPhone(){
        return phone;
    }

    public String getEmail(){
        return email;
    }
    

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    

    public Boolean getIsDeleted() { 
        return isDeleted; 
    }
    //Setter

    public void setId(Integer id){
        this.id=id;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public void setIdNumber(String idNumber){
        this.idNumber=idNumber;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public void setEmail(String email ){
        this.email=email;

    }

    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }
    
    public String getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(String identificationType) {
        this.identificationType = identificationType;
    }

    public void setIsDeleted(Boolean isDeleted) { 
        this.isDeleted = isDeleted; 
    }


}
