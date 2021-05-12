package com.example.notes.service;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import com.example.notes.dto.NoteCreateDto;
import com.example.notes.dto.NoteUpdateDto;
import com.example.notes.dto.NoteViewDto;

import java.util.List;

public interface NoteService {
    List<NoteViewDto> notes();

    List<Author> authors();

    List<Category> categories();

    NoteViewDto createNote(NoteCreateDto noteCreateDto);

    NoteViewDto updateNote(NoteUpdateDto noteUpdateDto);
}
