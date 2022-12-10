package com.bcr.backend_bcr.controller;

import com.bcr.backend_bcr.model.EmailDetails;
import com.bcr.backend_bcr.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmailSenderController {

    private final EmailService emailService;

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailDetails data) {
        emailService.sendEmail(data);
    }
}
