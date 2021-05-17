package com.example.notes.mapper.note;

import com.example.notes.data.Status;
import com.example.notes.domain.Category;
import com.example.notes.domain.Note;
import com.example.notes.dto.note.NoteUpdateDto;
import com.example.notes.mapper.Mapper;
import com.example.notes.repository.AuthorRepository;
import com.example.notes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class NoteUpdateMapper implements Mapper<NoteUpdateDto, Note> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public NoteUpdateDto toDto(Note note) {
        return null;
    }

    @Override
    public Note toModel(NoteUpdateDto noteUpdateDto) {
        return null;
    }

    @Override
    public void populateModel(Note note, NoteUpdateDto noteUpdateDto) {
        if (Objects.nonNull(noteUpdateDto.getContext())) note.setContext(noteUpdateDto.getContext());
        if (Objects.nonNull(noteUpdateDto.getStatus())) note.setStatus(Status.valueOf(noteUpdateDto.getStatus()));

        if (Objects.nonNull(noteUpdateDto.getCategoryId())) {
            Optional<Category> categoryOptional = categoryRepository.findById(noteUpdateDto.getCategoryId());
            note.setCategory(categoryOptional.get());
        }
    }

}
