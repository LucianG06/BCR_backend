package com.bcr.backend_bcr.service;

import com.bcr.backend_bcr.model.BCR_Office;
import com.bcr.backend_bcr.repository.BCR_OfficeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class BCR_OfficeService {

    private final BCR_OfficeRepository repository;

    public List<BCR_Office> getAllOffices() {
        return repository.findAll();
    }

    public List<BCR_Office> getOfficesByRegex(String regex) {
        return repository.findBCR_OfficeByRegex(regex);
    }

    public List<BCR_Office> getBCR_OfficeInCityByRegex(String regex, String city) {
        List<BCR_Office> offices = repository.findBCR_OfficeByRegex(regex);
        return offices.stream().filter(office -> Objects.equals(office.getOras(), city)).toList();
    }
}
