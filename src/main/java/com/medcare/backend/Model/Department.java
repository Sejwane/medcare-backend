package com.medcare.backend.Model;

import jakarta.persistence.*;


@Entity
@Table(name="departments")


public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="consultation_fee")
    private double consultationFee;

    //Blueprint has been set 

    public Department(){} 
    //After setting the blueprint then it is important to get to activate it for hibernate

    public Department(Integer id,String name,double consultationFee){
        this.id=id;
        this.name=name;
        this.consultationFee=consultationFee;
    }
    //Now getters and setters 

    public Integer getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getConsultationFee(){
        return consultationFee;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;

    }

    public void setConsultationFee(){
        this.consultationFee=consultationFee;
    }

}
