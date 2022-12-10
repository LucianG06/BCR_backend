package com.bcr.backend_bcr.controller;

import com.bcr.backend_bcr.model.BCR_Office;
import com.bcr.backend_bcr.service.BCR_OfficeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BCR_OfficeController {

    private final BCR_OfficeService service;

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
}
