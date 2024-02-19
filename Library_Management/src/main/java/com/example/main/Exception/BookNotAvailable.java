package com.example.main.Exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookNotAvailable extends RuntimeException {
    private String msg;
}
