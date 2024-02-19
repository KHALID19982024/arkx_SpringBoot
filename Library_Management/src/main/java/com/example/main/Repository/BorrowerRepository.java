package com.example.main.Repository;

import com.example.main.Entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BorrowerRepository extends JpaRepository<Borrower, Long> {
}
