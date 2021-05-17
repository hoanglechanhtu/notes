package com.example.notes.dto.note;

import com.example.notes.domain.Author;
import com.example.notes.domain.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteViewDto {
    private Long id;
    private String name;
    private String context;
    private Author author;
    private Category category;
}
