package com.example.notes.service.impl;

import com.example.notes.domain.Note;
import com.example.notes.repository.NoteRepository;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> notes() {
        return noteRepository.findAll();
    }
}
