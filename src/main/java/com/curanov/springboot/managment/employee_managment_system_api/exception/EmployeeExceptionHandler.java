package com.curanov.springboot.managment.employee_managment_system_api.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeIncorrectData> handleValidationException(MethodArgumentNotValidException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();

        StringBuilder sb = new StringBuilder();
        sb.append(exception.getMessage());

        // Getting the index of first Bracket
        int firstBracket = sb.lastIndexOf("[") + 1;
        //Getting the index of last Bracket
        int lastBracket = sb.lastIndexOf("]") - 1;

        data.setInfo(sb.substring(firstBracket, lastBracket));

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
