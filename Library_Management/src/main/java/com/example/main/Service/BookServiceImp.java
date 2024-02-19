package com.example.main.Service;

import com.example.main.Entity.Book;
import com.example.main.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("bookService")
public class BookServiceImp implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book>  bookDb = bookRepository.findById(book.getId());
        bookDb.ifPresent(value -> book.setId(value.getId()));
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}
