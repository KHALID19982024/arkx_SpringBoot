package com.example.main.Controller;

import com.example.main.Entity.Author;
import com.example.main.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAuthors();
    }


    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.getAuthor(id);
    }



    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }



    @DeleteMapping("/{id}")
    public void deleleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }



    @PutMapping
    public Author updateAuthor(@RequestBody Author author) {
        return authorService.updateAuthor(author);
    }

}
