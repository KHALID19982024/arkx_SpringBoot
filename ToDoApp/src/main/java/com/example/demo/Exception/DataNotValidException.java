package com.example.demo.Exception;

public class DataNotValidException extends RuntimeException {
    public DataNotValidException(String message) {
        super(message);
    }
}
