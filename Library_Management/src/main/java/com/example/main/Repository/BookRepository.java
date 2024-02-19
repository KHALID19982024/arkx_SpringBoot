package com.example.main.Repository;

import com.example.main.Entity.Book;
import com.example.main.Entity.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> getByIdAndStatus(Long id, BookStatus status);
}
