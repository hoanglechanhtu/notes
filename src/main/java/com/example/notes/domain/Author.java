package com.example.notes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
public class Author extends Domain implements Serializable {
    @Column
    private String uuid;

    @Column
    private String name;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Set<Note> noteSet;
}
