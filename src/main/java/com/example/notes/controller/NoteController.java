package com.example.notes.controller;

import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping(value = "/notes")
    ResponseEntity notes() {
        return ResponseEntity.ok(noteService.notes());
    }
}
