package com.bcr.backend_bcr.controller;

import com.bcr.backend_bcr.model.Appointment;
import com.bcr.backend_bcr.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping("/makeAppointment")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("/getByOfficeId/{officeId}")
    public List<Appointment> getAppointmentsByOfficeId(@PathVariable Integer officeId) {
        return appointmentService.getAppointmentsByOfficeId(officeId);
    }
}
