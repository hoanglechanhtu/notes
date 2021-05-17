package com.example.notes.controller;

import com.example.notes.dto.author.AuthorCreateDto;
import com.example.notes.dto.author.AuthorUpdateDto;
import com.example.notes.dto.author.AuthorViewDto;
import com.example.notes.dto.note.NoteCreateDto;
import com.example.notes.dto.note.NoteUpdateDto;
import com.example.notes.dto.note.NoteViewDto;
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

    @ApiOperation(value = "Create note")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AuthorViewDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = AuthorViewDto.class)
    })
    @PostMapping(value = "/authors")
    ResponseEntity createAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
        noteService.createAuthor(authorCreateDto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Update note")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = AuthorViewDto.class),
            @ApiResponse(code = 400, message = "Bad request", response = AuthorViewDto.class)
    })
    @PutMapping(value = "/authors")
    ResponseEntity updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto) {
        noteService.updateAuthor(authorUpdateDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/categories")
    ResponseEntity categories() {
        return ResponseEntity.ok(noteService.categories());
    }
}
