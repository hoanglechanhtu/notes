package com.example.notes.mapper.author;

import com.example.notes.domain.Author;
import com.example.notes.dto.author.AuthorUpdateDto;
import com.example.notes.mapper.Mapper;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthorUpdateMapper implements Mapper<AuthorUpdateDto, Author> {
    @Override
    public AuthorUpdateDto toDto(Author author) {
        return null;
    }

    @Override
    public Author toModel(AuthorUpdateDto authorUpdateDto) {
        return null;
    }

    @Override
    public void populateModel(Author author, AuthorUpdateDto authorUpdateDto) {
        if (Objects.nonNull(authorUpdateDto.getName())) author.setName(authorUpdateDto.getName());

    }
}
