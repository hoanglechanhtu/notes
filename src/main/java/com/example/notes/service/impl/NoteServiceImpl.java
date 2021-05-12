package com.example.notes.service.impl;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import com.example.notes.domain.Note;
import com.example.notes.dto.NoteCreateDto;
import com.example.notes.dto.NoteUpdateDto;
import com.example.notes.dto.NoteViewDto;
import com.example.notes.mapper.NoteCreateMapper;
import com.example.notes.mapper.NoteUpdateMapper;
import com.example.notes.mapper.NoteViewMapper;
import com.example.notes.repository.AuthorRepository;
import com.example.notes.repository.CategoryRepository;
import com.example.notes.repository.NoteRepository;
import com.example.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteCreateMapper noteCreateMapper;
    @Autowired
    private NoteUpdateMapper noteUpdateMapper;
    @Autowired
    private NoteViewMapper noteViewMapper;

    @Override
    public List<NoteViewDto> notes() {
        return noteRepository.findAll().stream().map(note -> noteViewMapper.toDto(note)).collect(Collectors.toList());
    }

    @Override
    public NoteViewDto createNote(NoteCreateDto noteCreateDto) {
        Note note = noteCreateMapper.toModel(noteCreateDto);
        noteRepository.save(note);
        return noteViewMapper.toDto(note);
    }

    @Override
    public NoteViewDto updateNote(NoteUpdateDto noteUpdateDto) {
        Optional<Note> noteOptional = noteRepository.findById(noteUpdateDto.getId());
        if (noteOptional.isPresent()) {
            noteUpdateMapper.populateModel(noteOptional.get(), noteUpdateDto);
            noteRepository.save(noteOptional.get());
            return noteViewMapper.toDto(noteOptional.get());
        }
        return null;
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
