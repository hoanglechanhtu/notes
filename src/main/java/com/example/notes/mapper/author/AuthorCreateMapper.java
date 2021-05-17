package com.example.notes.mapper.author;

import com.example.notes.domain.Author;
import com.example.notes.dto.author.AuthorCreateDto;
import com.example.notes.mapper.Mapper;
import com.example.notes.repository.AuthorRepository;
import com.example.notes.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class AuthorCreateMapper implements Mapper<AuthorCreateDto, Author> {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public AuthorCreateDto toDto(Author author) {
        return AuthorCreateDto.builder()
                .name(author.getName())
                .build();
    }

    @Override
    public Author toModel(AuthorCreateDto authorCreateDto) {
        return Author.builder()
                .uuid(UUID.randomUUID().toString())
                .name(authorCreateDto.getName())
                .build();
    }

    @Override
    public void populateModel(Author author, AuthorCreateDto authorCreateDto) {
        if (Objects.nonNull(authorCreateDto.getName())) author.setName(authorCreateDto.getName());
    }
}
