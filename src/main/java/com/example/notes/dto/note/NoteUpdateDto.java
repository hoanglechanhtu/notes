package com.example.notes.dto.note;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class NoteUpdateDto {
    @NonNull
    private Long id;
    private String context;
    private Long categoryId;
    private String status;
}
