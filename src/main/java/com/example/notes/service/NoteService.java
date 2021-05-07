package com.example.notes.service;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import com.example.notes.domain.Note;

import java.util.List;

public interface NoteService {
    List<Note> notes();
    List<Author> authors();
    List<Category> categories();
}
