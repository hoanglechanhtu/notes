package com.example.notes.controller;

import com.example.notes.dto.NoteCreateDto;
import com.example.notes.dto.NoteUpdateDto;
import com.example.notes.dto.NoteViewDto;
import com.example.notes.service.NoteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @ApiOperation(value = "Get list notes")
    @GetMapping(value = "/notes")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = NoteViewDto[].class),
            @ApiResponse(code = 400, message = "Bad request", response = NoteViewDto[].class)
    })
    ResponseEntity notes() {
        return ResponseEntity.ok(noteService.notes());
    }

    @ApiOperation(value = "Create note")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = NoteViewDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = NoteViewDto.class)
    })
    @PostMapping(value = "/notes")
    ResponseEntity createNotes(@RequestBody NoteCreateDto noteCreateDto) {
        noteService.createNote(noteCreateDto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Update note")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = NoteViewDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = NoteViewDto.class)
    })
    @PutMapping(value = "/notes")
    ResponseEntity updateNotes(@RequestBody NoteUpdateDto noteUpdateDto) {
        noteService.updateNote(noteUpdateDto);
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
