package com.example.notes.mapper.author;

import com.example.notes.domain.Author;
import com.example.notes.dto.author.AuthorViewDto;
import com.example.notes.mapper.Mapper;
import com.example.notes.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthorViewMapper implements Mapper<AuthorViewDto, Author> {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorViewDto toDto(Author author) {
        return AuthorViewDto.builder()
                .uuid(author.getUuid())
                .name(author.getName())
                .build();
    }

    @Override
    public Author toModel(AuthorViewDto authorViewDto) {
        return Author.builder()
                .name(authorViewDto.getName())
                .uuid(authorViewDto.getUuid())
                .build();
    }

    @Override
    public void populateModel(Author author, AuthorViewDto authorViewDto) {
        if (Objects.nonNull(authorViewDto.getName())) author.setName(authorViewDto.getName());
    }
}
