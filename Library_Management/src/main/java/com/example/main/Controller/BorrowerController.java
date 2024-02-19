package com.example.main.Controller;

import com.example.main.Entity.Borrower;
import com.example.main.Service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/borrowers")
public class BorrowerController {

    @Autowired
    BorrowerService borrowerService;
    @GetMapping
    public List<Borrower> getBorrowers(){
        return borrowerService.getBorrowers();
    }
    @GetMapping("/{id}")
    public Borrower getBorrower(@PathVariable Long id){
        return borrowerService.getBorrower(id);
    }
    @PostMapping
    public Borrower createBorrower(@RequestBody Borrower borrower){
        return borrowerService.createBorrower(borrower);
    }

    @PutMapping
    public Borrower updateBorrower(@RequestBody Borrower borrower){
        return borrowerService.updateBorrower(borrower);
    }
    @DeleteMapping("/{id}")
    public void deleteBorrower(@PathVariable Long id){
        borrowerService.deleteBorrower(id);
    }
}