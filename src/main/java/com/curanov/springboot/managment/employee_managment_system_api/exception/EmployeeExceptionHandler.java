package com.curanov.springboot.managment.employee_managment_system_api.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(EmployeeServiceException.class)
    public ResponseEntity<EmployeeIncorrectData> handleException(EmployeeServiceException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<EmployeeIncorrectData> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo("Failed to save employee due to data integrity violation.");

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
