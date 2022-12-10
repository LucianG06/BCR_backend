package com.bcr.backend_bcr.controller;

import com.bcr.backend_bcr.model.BCR_Office;
import com.bcr.backend_bcr.service.BCR_OfficeService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class BCR_OfficeController {

    private final BCR_OfficeService service;

    @PostMapping("/post/{id}")
    public void post(@PathVariable Integer id) {
        service.postId(id);
    }

    @GetMapping("/getAllOffices")
    public List<BCR_Office> getAllOffices() {
        return service.getAllOffices();
    }

    @GetMapping("/getAllByRegex/{regex}")
    public List<BCR_Office> getOfficesByRegex(@PathVariable String regex) {
        return service.getOfficesByRegex(regex);
    }

    @GetMapping("/getAllInCityByRegex/{regex}/{city}")
    public List<BCR_Office> getAllOfficeInCityByRegex(@PathVariable String regex, @PathVariable String city) {
        return service.getBCR_OfficeInCityByRegex(regex, city);
    }

    @GetMapping("/getHoursForBCR_OfficeDate/{date}")
    public List<LocalTime> getHoursForBCR_OfficeDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return service.getHoursForBCR_OfficeDate(date);
    }

    @PostMapping("/makeAppointemnt/{dateTime}/{email}")
    public void makeAppointment(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime,
                                @PathVariable String email) {
        service.makeAppointment(dateTime, email);
    }

    @PostMapping("/sendSms/{telefon}")
    public void sendSms(@PathVariable String telefon) {
        service.sendSms(telefon);
    }

    @GetMapping("/checkStatus/{code}")
    public String checkCode(@PathVariable String code) {
        return service.checkCode(code);
    }
}
