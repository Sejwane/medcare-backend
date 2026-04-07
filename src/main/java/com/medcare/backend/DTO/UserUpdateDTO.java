package com.medcare.backend.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UserUpdateDTO {
    @NotBlank(message = "First name cannot be empty")
    private String firstName;

    private String lastName; //it has been optional

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Must be a valid email format")
    private String email;

   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
