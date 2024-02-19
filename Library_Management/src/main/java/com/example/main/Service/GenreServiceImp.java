package com.example.main.Service;

import com.example.main.Entity.Genre;
import com.example.main.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("genreService")
public class GenreServiceImp implements GenreService{

    @Autowired
    GenreRepository genreRepository;
    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        Optional<Genre> optionalGenre = genreRepository.findById(genre.getId());
        if (optionalGenre.isPresent()){
            genre.setId(optionalGenre.get().getId());
            genreRepository.save(genre);
        }
        return genre;
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }
}
