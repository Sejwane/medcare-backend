package com.medcare.backend.Repository;
import com.medcare.backend.Model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

}
