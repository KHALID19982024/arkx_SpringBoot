package com.example.main.Service;

import com.example.main.Entity.Author;
import com.example.main.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("authorService")
public class AuthorServiceImp implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author getAuthor(Long id) {
        Optional<Author> author = authorRepository.findById(id);
        return author.orElse(null);
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        Optional<Author> authorDb = authorRepository.findById(author.getId());
        authorDb.ifPresent(value -> author.setId(value.getId()));
        return authorRepository.save(author);
    }

    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

}
