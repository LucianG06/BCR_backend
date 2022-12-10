package com.bcr.backend_bcr.service;

import com.bcr.backend_bcr.model.Appointment;
import com.bcr.backend_bcr.repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointmentsByOfficeId(Integer officeId) {
        return appointmentRepository.findAppointmentsByOfficeId(officeId);
    }
}
