package com.example.notes.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @GetMapping(value = "/notes")
    ResponseEntity notes() {

    }
}
