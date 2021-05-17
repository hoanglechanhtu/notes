package com.example.notes.dto.author;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorUpdateDto {
    @NonNull
    private String uuid;
    private String name;
}
