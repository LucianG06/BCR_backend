package com.bcr.backend_bcr.repository;

import com.bcr.backend_bcr.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query("SELECT p FROM Appointment p WHERE p.officeId=?1")
    List<Appointment> findAppointmentsByOfficeId(Integer officeId);
}
