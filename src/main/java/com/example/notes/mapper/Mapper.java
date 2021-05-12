package com.example.notes.mapper;

public interface Mapper<T, D> {
    T toDto(D d);

    D toModel(T t);

    void populateModel(D d, T t);
}
