package com.example.main.Service;

import com.example.main.Entity.Borrower;

import java.util.List;

public interface BorrowerService {
    List<Borrower> getBorrowers();

    Borrower getBorrower(Long id);

    Borrower createBorrower(Borrower borrower);

    Borrower updateBorrower(Borrower borrower);

    void deleteBorrower(Long id);
}