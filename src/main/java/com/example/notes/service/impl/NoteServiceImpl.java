package com.example.notes.service.impl;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import com.example.notes.domain.Note;
import com.example.notes.repository.AuthorRepository;
import com.example.notes.repository.CategoryRepository;
import com.example.notes.repository.NoteRepository;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Note> notes() {
        return noteRepository.findAll();
    }

    @Override
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Category> categories() {
        return categoryRepository.findAll();
    }
}
