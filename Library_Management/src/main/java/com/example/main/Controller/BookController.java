package com.example.main.Controller;

import com.example.main.Entity.Book;
import com.example.main.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }



    @GetMapping(path ="/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }



    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }



    @DeleteMapping(path ="/{id}")
    public void deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

}
