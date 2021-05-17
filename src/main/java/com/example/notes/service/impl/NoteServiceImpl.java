package com.example.notes.service.impl;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import com.example.notes.domain.Note;
import com.example.notes.dto.author.AuthorCreateDto;
import com.example.notes.dto.author.AuthorUpdateDto;
import com.example.notes.dto.author.AuthorViewDto;
import com.example.notes.dto.note.NoteCreateDto;
import com.example.notes.dto.note.NoteUpdateDto;
import com.example.notes.dto.note.NoteViewDto;
import com.example.notes.mapper.author.AuthorCreateMapper;
import com.example.notes.mapper.author.AuthorUpdateMapper;
import com.example.notes.mapper.author.AuthorViewMapper;
import com.example.notes.mapper.note.NoteCreateMapper;
import com.example.notes.mapper.note.NoteUpdateMapper;
import com.example.notes.mapper.note.NoteViewMapper;
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
    @Autowired
    private AuthorCreateMapper authorCreateMapper;
    @Autowired
    private AuthorUpdateMapper authorUpdateMapper;
    @Autowired
    private AuthorViewMapper authorViewMapper;

    @Override
    public AuthorViewDto updateAuthor(AuthorUpdateDto authorUpdateDto) {
        Optional<Author> authorOpt = authorRepository.findByUuid(authorUpdateDto.getUuid());
        authorOpt.ifPresent(author -> {
            authorUpdateMapper.populateModel(author, authorUpdateDto);
            authorRepository.save(author);
        });

        return authorOpt.map(author -> authorViewMapper.toDto(author)).orElse(null);
    }

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
    public List<AuthorViewDto> authors() {
        return authorRepository.findAll().stream().map(author -> authorViewMapper.toDto(author)).collect(Collectors.toList());
    }

    @Override
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @Override
    public AuthorViewDto createAuthor(AuthorCreateDto authorCreateDto) {
        Author author = authorCreateMapper.toModel(authorCreateDto);
        authorRepository.save(author);
        return authorViewMapper.toDto(author);
    }
}
