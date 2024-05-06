package org.example.jp2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @GetMapping("/myContacts")
    public String getContact() {
        return "contact details";
    }
}
