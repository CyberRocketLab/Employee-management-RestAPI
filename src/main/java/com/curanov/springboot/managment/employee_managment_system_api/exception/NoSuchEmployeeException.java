package com.curanov.springboot.managment.employee_managment_system_api.exception;

public class NoSuchEmployeeException extends RuntimeException {
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
