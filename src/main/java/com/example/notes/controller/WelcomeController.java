package com.example.notes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping(value = "/welcome")
    ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome");
    }

    @GetMapping(value = "/welcome2")
    ResponseEntity<String> welcome2() {
        return ResponseEntity.ok("Welcome - Test code build");
    }
}
