package com.bcr.backend_bcr.service;

import com.bcr.backend_bcr.model.EmailDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    public void sendEmail(EmailDetails emailDetails) {

        String[] params = {"C:\\Users\\lucia\\AppData\\Local\\Programs\\Python\\Python311\\python.exe", "src\\main\\resources\\send_email.py",
                            emailDetails.getEmail_rec(), emailDetails.getDenumireLocatie(), emailDetails.getLatitudine().toString(), emailDetails.getLongitudine().toString(),
                            emailDetails.getData(), emailDetails.getOra(), emailDetails.getStrada()};
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
}
