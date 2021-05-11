package com.example.notes.controller;

import com.example.notes.dto.NoteCreateDto;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping(value = "/notes")
    ResponseEntity notes() {
        return ResponseEntity.ok(noteService.notes());
    }

    @PostMapping(value = "/notes")
    ResponseEntity createNotes(@RequestBody NoteCreateDto noteCreateDto) {
        noteService.createNote(noteCreateDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/authors")
    ResponseEntity authors() {
        return ResponseEntity.ok(noteService.authors());
    }

    @GetMapping(value = "/categories")
    ResponseEntity categories() {
        return ResponseEntity.ok(noteService.categories());
    }
}
