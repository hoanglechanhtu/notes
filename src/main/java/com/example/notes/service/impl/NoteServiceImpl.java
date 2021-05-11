package com.example.notes.service.impl;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import com.example.notes.domain.Note;
import com.example.notes.dto.NoteCreateDto;
import com.example.notes.mapper.NoteMapper;
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
    CategoryRepository categoryRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public List<Note> notes() {
        return noteRepository.findAll();
    }

    @Override
    public void createNote(NoteCreateDto noteCreateDto) {
        Note note = noteMapper.toModel(noteCreateDto);
        noteRepository.save(note);
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
