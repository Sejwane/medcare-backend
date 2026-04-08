package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.Appointment;
import com.medcare.backend.DTO.AppointmentUpdateDTO;
import com.medcare.backend.Service.AppointmentService;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.Optional;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/appointments")
@CrossOrigin(origins="*")

public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/register")
    public Appointment register(@RequestBody Appointment appointment) {
        
        return appointmentService.register(appointment);
    }

    @GetMapping("/all")
    public List<Appointment>getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Appointment>updateAppointment(
        @PathVariable Integer id,
        @Valid @RequestBody AppointmentUpdateDTO updateDTO) {

            Optional<Appointment> update=appointmentService.updateAppointment(id , updateDTO);

            return update.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

        }
    
    
}
