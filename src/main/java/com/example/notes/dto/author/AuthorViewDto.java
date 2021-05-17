package com.example.notes.dto.author;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthorViewDto {
    private String uuid;
    private String name;
}
