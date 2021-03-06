package com.example.notes.mapper.note;

import com.example.notes.data.Status;
import com.example.notes.domain.Note;
import com.example.notes.dto.note.NoteCreateDto;
import com.example.notes.mapper.Mapper;
import com.example.notes.repository.AuthorRepository;
import com.example.notes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class NoteCreateMapper implements Mapper<NoteCreateDto, Note> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public NoteCreateDto toDto(Note note) {
        return null;
    }

    @Override
    public Note toModel(NoteCreateDto noteCreateDto) {
        if (Objects.isNull(noteCreateDto)) return null;
        return Note.builder()
                .uuid(UUID.randomUUID().toString())
                .name(noteCreateDto.getName())
                .context(noteCreateDto.getContext())
                .status(Status.ACTIVATED)
                .author(Objects.nonNull(noteCreateDto.getAuthorId()) ? authorRepository.findById(noteCreateDto.getAuthorId()).orElse(null) : null)
                .category(Objects.nonNull(noteCreateDto.getCategoryId()) ? categoryRepository.findById(noteCreateDto.getCategoryId()).orElse(null) : null)
                .build();

    }

    @Override
    public void populateModel(Note note, NoteCreateDto noteCreateDto) {
    }
}
