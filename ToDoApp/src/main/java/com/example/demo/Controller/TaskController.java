package com.example.demo.Controller;

import com.example.demo.Entity.DTO.TaskRequestDto;
import com.example.demo.Entity.DTO.TaskResponseDto;
import com.example.demo.Exception.DataNotValidException;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    // add CRUD methods
    // add ExceptionHandling
    // create custom exceptions NotFoundException, DataNotValidException, etc.
    // BONUS : Add Swagger documentation (OpenAPI)!
    @GetMapping("/")
    public ResponseEntity<?> getAllTasks() {

        try {
            return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskRequestDto taskDto) {
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {

        try {
            return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update a task by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(@PathVariable Long id, @Valid @RequestBody TaskRequestDto taskDto) {
        try {
            return new ResponseEntity<>(taskService.updateTask(id, taskDto), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete a task by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {

        try {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
