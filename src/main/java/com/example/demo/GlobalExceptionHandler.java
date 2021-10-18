package com.example.demo;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false), 500);
        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "User already exist", request.getDescription(false), 409);
        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> missingDataExceptionHandler(Exception ex, WebRequest request) {
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Missing data already exist", request.getDescription(false), 400);
//        return new ResponseEntity<>(errorDetails, HttpStatus.OK);
//    }
}