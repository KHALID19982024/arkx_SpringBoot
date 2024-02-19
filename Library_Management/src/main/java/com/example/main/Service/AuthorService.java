package com.example.main.Service;

import com.example.main.Entity.Author;

import java.util.List;

public interface AuthorService {

    Author getAuthor(Long id);

    Author createAuthor(Author author);

    void deleteAuthor(Long id);

    Author updateAuthor(Author author);

    List<Author> getAuthors();
}
