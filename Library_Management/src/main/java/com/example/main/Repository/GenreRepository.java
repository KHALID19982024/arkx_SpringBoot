package com.example.main.Repository;

import com.example.main.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
public interface GenreRepository extends JpaRepository<Genre, Long> {
}