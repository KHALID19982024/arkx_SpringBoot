package com.example.demo.Controller;

import com.example.demo.Entity.DTO.UserRequestDto;
import com.example.demo.Entity.DTO.UserResponseDto;
import com.example.demo.Exception.DataNotValidException;
import com.example.demo.Exception.NotFoundException;
import com.example.demo.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/users", produces = "application/json", consumes = "application/json")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        try {
            var user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto requestDto) {
        try {
            UserResponseDto updatedUser = userService.updateUser(id, requestDto);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (DataNotValidException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
