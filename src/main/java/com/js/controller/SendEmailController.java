package com.js.controller;

import com.js.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping("/sendMail")
    public Integer sendMail(@RequestParam("mail")String mail){
        return emailService.sendMail(mail);
    }
}
