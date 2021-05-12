package com.dockerize.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0")
public class ProfileController {

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping("/profile")
    public String profileController() {
        return profile;
    }
}
