package com.bcr.backend_bcr.controller;

import com.bcr.backend_bcr.model.EmailData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailSenderController {

    @PostMapping("/sendEmail")
    public void sendEmail(@RequestBody EmailData data) {

    }
}
