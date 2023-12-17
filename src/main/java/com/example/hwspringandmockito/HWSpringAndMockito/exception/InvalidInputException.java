package com.example.hwspringandmockito.HWSpringAndMockito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidInputException extends Exception {

    public InvalidInputException() {
        super("Плохой запрос");
    }

}
