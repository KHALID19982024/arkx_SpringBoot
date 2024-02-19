package com.example.main.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(name="Books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="Title")
    private String title;

    @Column(name="isbn")
    private String isbn;


    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
