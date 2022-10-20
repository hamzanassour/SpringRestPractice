package com.rest.controllers;

import com.rest.entities.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleglobalexception(Exception exception){
        System.out.println("exception handler in controller advice ");
        ExceptionResponse response = new ExceptionResponse();
        response.setDate(new Date());
        response.setErrorClass(exception.getClass().toString());
        response.setErrorMessage(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
