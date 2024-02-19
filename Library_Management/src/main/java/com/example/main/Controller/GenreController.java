package com.example.main.Controller;

import com.example.main.Entity.Genre;
import com.example.main.Service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/genres")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    @GetMapping(path = "/{id}")
    public Genre getGenre(@PathVariable Long id) {
        return genreService.getGenre(id);
    }


    @PostMapping
    public Genre createGenre(@RequestBody Genre genre) {
        return genreService.createGenre(genre);
    }


    @DeleteMapping(path = "/{id}")
    public void deleteGenre(@RequestParam Long id) {
        genreService.deleteGenre(id);
    }

    @PostMapping(path = "/")
    public Genre updateGenre(@RequestBody Genre genre) {
        return genreService.updateGenre(genre);
    }

}
