package com.example.notes.domain;

import com.example.notes.data.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "note")
public class Note extends Domain implements Serializable {
    @Column
    private String uuid;

    @Column
    private String name;

    @Column
    private String context;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;
}
