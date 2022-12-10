package com.bcr.backend_bcr.service;

import com.bcr.backend_bcr.model.BCR_Office;
import com.bcr.backend_bcr.repository.BCR_OfficeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class BCR_OfficeService {

    private final BCR_OfficeRepository repository;

    public List<BCR_Office> getAllOffices() {
        return repository.findAll();
    }

    public List<BCR_Office> getOfficesByRegex(String regex) {
//        List<BCR_Office> offices = new ArrayList<>();
//        List<BCR_Office> allOffices = repository.findAll();
//        Pattern pattern = Pattern.compile(regex);
//
//        for (BCR_Office office : allOffices) {
//            if (pattern.matcher(office.getNume()).matches()) {
//                if (!offices.contains(office)) {
//                    offices.add(office);
//                }
//            }
//        }
//
//        for (BCR_Office office : allOffices) {
//            if (pattern.matcher(office.getStrada()).matches()) {
//                if (!offices.contains(office)) {
//                    offices.add(office);
//                }
//            }
//        }
//
//        for (BCR_Office office : allOffices) {
//            if (pattern.matcher(office.getOras()).matches()) {
//                if (!offices.contains(office)) {
//                    offices.add(office);
//                }
//            }
//        }

        return repository.findBCR_OfficeByRegex(regex);
    }
}
