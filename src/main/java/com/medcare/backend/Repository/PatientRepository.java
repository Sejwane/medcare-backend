package com.medcare.backend.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.medcare.backend.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;


@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    @Modifying
    @Query(value = "UPDATE patients SET is_deleted = false WHERE id = :id", nativeQuery = true)
    void restorePatient(@Param("id") Integer id);

}
