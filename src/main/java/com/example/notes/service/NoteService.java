package com.example.notes.service;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import com.example.notes.domain.Note;
import com.example.notes.dto.NoteCreateDto;
import com.example.notes.dto.NoteUpdateDto;

import java.util.List;

public interface NoteService {
    List<Note> notes();

    List<Author> authors();

    List<Category> categories();

    void createNote(NoteCreateDto noteCreateDto);

    void updateNote(NoteUpdateDto noteUpdateDto);
}
