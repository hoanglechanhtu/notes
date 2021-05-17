package com.example.notes.dto.author;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class AuthorCreateDto {
    @NonNull
    private String name;
}
