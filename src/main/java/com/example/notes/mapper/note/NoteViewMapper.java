package com.example.notes.mapper.note;

import com.example.notes.domain.Note;
import com.example.notes.dto.note.NoteViewDto;
import com.example.notes.mapper.Mapper;
import com.example.notes.repository.AuthorRepository;
import com.example.notes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NoteViewMapper implements Mapper<NoteViewDto, Note> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public NoteViewDto toDto(Note note) {
        return NoteViewDto.builder()
                .id(note.getId())
                .name(note.getName())
                .context(note.getContext())
                .author(note.getAuthor())
                .category(note.getCategory())
                .build();
    }

    @Override
    public Note toModel(NoteViewDto noteViewDto) {
        return null;
    }

    @Override
    public void populateModel(Note note, NoteViewDto noteViewDto) {
    }

}
