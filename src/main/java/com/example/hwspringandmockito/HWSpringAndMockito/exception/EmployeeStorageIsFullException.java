package com.example.hwspringandmockito.HWSpringAndMockito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
public class EmployeeStorageIsFullException extends Exception {

    public EmployeeStorageIsFullException() {
        super("Количество сотрудников достигло максимального размера. Невозможно добавить нового сотрудника");
    }

}