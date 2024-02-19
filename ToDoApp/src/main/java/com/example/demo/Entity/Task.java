package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Check if null
    @NotNull
    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;

    //Change to enum
    //Check if null
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    //Check if null
    //Check if date is valid (due date in the futur)

    @Column(name = "due_date")
    @Future
    @NotNull
    private Date dueDate;


    @Column(name = "created_at")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
}
