package com.bcr.backend_bcr.service;

import com.bcr.backend_bcr.model.BCR_Office;
import com.bcr.backend_bcr.repository.BCR_OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class BCR_OfficeService {

    private final BCR_OfficeRepository repository;
    public Integer officeId;
    public String phoneNumber;
    public Map<LocalDate, List<LocalTime>> availableHours = new HashMap<>();

    public void calculateAvailableHours(LocalDate date) {
        if (!availableHours.isEmpty()) {
            return;
        }
        List<LocalTime> hours = new ArrayList<>();

        String[] stringHours = repository.findById(officeId).get().getDeschis().split(" si | - |:");

        LocalTime firstStartHour = LocalTime.of(Integer.parseInt(stringHours[0]), Integer.parseInt(stringHours[1]));
        LocalTime firstEndHour = LocalTime.of(Integer.parseInt(stringHours[2]), Integer.parseInt(stringHours[3]));
        LocalTime secondStartHour = LocalTime.of(Integer.parseInt(stringHours[4]), Integer.parseInt(stringHours[5]));
        LocalTime secondEndHour = LocalTime.of(Integer.parseInt(stringHours[6]), Integer.parseInt(stringHours[7]));

        for(LocalTime time = firstStartHour; time.isBefore(firstEndHour); time = time.plusMinutes(30)) {
            hours.add(time);
        }

        for(LocalTime time = secondStartHour; time.isBefore(secondEndHour); time = time.plusMinutes(30)) {
            hours.add(time);
        }

        availableHours.put(date, hours);
    }

    public void makeAppointment(LocalDate date, LocalTime time) {
        availableHours.get(date).remove(time);
    }

    public List<BCR_Office> getAllOffices() {
        return repository.findAll();
    }

    public void postId(Integer id) {
        officeId = id;
    }

    public List<BCR_Office> getOfficesByRegex(String regex) {
        List<BCR_Office> offices = repository.findBCR_OfficeByRegex(regex);

        offices.sort(Comparator.comparingDouble(office -> Double.parseDouble(office.getDistanta().split(" km")[0])));
        return offices;
    }

    public List<BCR_Office> getBCR_OfficeInCityByRegex(String regex, String city) {
        List<BCR_Office> offices = repository.findBCR_OfficeByRegex(regex);
        return offices.stream().filter(office -> Objects.equals(office.getOras(), city)).toList();
    }

    public List<LocalTime> getHoursForBCR_OfficeDate(LocalDate date) {
        calculateAvailableHours(date);

        return availableHours.get(date);
    }

    public void makeAppointment(LocalDateTime dateTime, String email) {
        BCR_Office office = repository.findById(officeId).get();
        LocalDate date = LocalDate.of(dateTime.getYear(), dateTime.getMonth(), dateTime.getDayOfMonth());
        LocalTime time = LocalTime.of(dateTime.getHour(), dateTime.getMinute());
        String[] params = {"C:\\Users\\lucia\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", "src\\main\\resources\\send_email.py",
                email, office.getNume(), office.getLatitudine(), office.getLongitudine(),
                date.toString(), time.toString(), office.getStrada()};
        try {
            Process p = Runtime.getRuntime().exec(params);
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        makeAppointment(date, time);
    }

    public void sendSms(String telefon) {
        phoneNumber = telefon;
        String[] params = {"C:\\Users\\lucia\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", "src\\main\\resources\\send_sms.py",
                telefon};
        try {
            Process p = Runtime.getRuntime().exec(params);
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkCode(String code) {
        String[] params = {"C:\\Users\\lucia\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", "src\\main\\resources\\check_code.py",
                phoneNumber, code};
        try {
            Process p = Runtime.getRuntime().exec(params);
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("src/main/resources/static/code.txt");
        try {
            BufferedReader read = new BufferedReader(new FileReader(file));
            try {
                String status = read.readLine();
                read.close();
                file.delete();
                return status;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
