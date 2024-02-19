package com.example.main.Service;

import com.example.main.Entity.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> getGenres();

    Genre getGenre(Long id);

    Genre updateGenre(Genre genre);

    void deleteGenre(Long id);

    Genre createGenre(Genre genre);
}
