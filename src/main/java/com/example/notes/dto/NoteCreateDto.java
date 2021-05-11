package com.example.notes.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class NoteCreateDto {
    @NonNull
    private String name;
    @NonNull
    private String context;
    @NonNull
    private Long authorId;
    @NonNull
    private Long categoryId;
}
