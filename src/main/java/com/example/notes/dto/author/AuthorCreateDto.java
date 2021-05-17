package com.example.notes.dto.author;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateDto {
    @NonNull
    private String name;
}
