package com.medcare.backend.Service;
import com.medcare.backend.Model.Appointment;
import com.medcare.backend.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment register(Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    public List<Appointment>getAllAppointments(){
        return appointmentRepository.findAll();
    }

}
