package com.example.notes.service;

import com.example.notes.domain.Category;
import com.example.notes.dto.author.AuthorCreateDto;
import com.example.notes.dto.author.AuthorUpdateDto;
import com.example.notes.dto.author.AuthorViewDto;
import com.example.notes.dto.note.NoteCreateDto;
import com.example.notes.dto.note.NoteUpdateDto;
import com.example.notes.dto.note.NoteViewDto;

import java.util.List;

public interface NoteService {
    List<NoteViewDto> notes();

    List<AuthorViewDto> authors();

    List<Category> categories();

    NoteViewDto createNote(NoteCreateDto noteCreateDto);

    NoteViewDto updateNote(NoteUpdateDto noteUpdateDto);

    AuthorViewDto createAuthor(AuthorCreateDto authorCreateDto);

    AuthorViewDto updateAuthor(AuthorUpdateDto authorUpdateDto);
}
