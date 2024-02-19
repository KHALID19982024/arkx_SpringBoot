package com.example.main.Service;

import com.example.main.Entity.Book;

import java.util.List;

public interface BookService {

    Book getBook(Long id);

    Book createBook(Book book);

    void deleteBook(Long id);

    Book updateBook(Book book);

    List<Book> getBooks();
}
