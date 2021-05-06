package com.example.notes.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author extends Domain implements Serializable {
    @Column
    private String uuid;

    @Column
    private String name;
}
