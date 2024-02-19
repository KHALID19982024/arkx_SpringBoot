package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Check if null
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    //Check if null
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    //Check if null & validate email & unique
    @NonNull
    @Email
    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks = new ArrayList<>();

}
