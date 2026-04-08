package com.medcare.backend.Service;
import com.medcare.backend.DTO.AppointmentUpdateDTO;
import com.medcare.backend.Model.Appointment;
import com.medcare.backend.Repository.AppointmentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


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

   @Transactional
public Optional<Appointment> updateAppointment(Integer id, AppointmentUpdateDTO updateDTO){
    return appointmentRepository.findById(id).map(appointment -> {
        if ("COMPLETED".equals(appointment.getStatus()) || "CANCELLED".equals(appointment.getStatus())){
            throw new IllegalStateException("Cannot modify an appointment that is " + appointment.getStatus());
        }

        
        if (updateDTO.getAppointmentDate() != null) appointment.setAppointmentDate(updateDTO.getAppointmentDate());
        if (updateDTO.getAppointmentTime() != null) appointment.setAppointmentTime(updateDTO.getAppointmentTime());

        
        return appointmentRepository.save(appointment);
    });
}

    

}
