package com.medcare.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medcare.backend.Model.Appointment;
import com.medcare.backend.Service.AppointmentService;

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
    

}
