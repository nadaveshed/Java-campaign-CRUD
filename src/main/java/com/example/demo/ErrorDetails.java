package com.example.demo;

import org.springframework.http.HttpStatus;

import java.util.Date;

public class ErrorDetails {

    private int error;
    private Date timestamp;
    private String message;
    private String details;

    public ErrorDetails(Date timestamp, String message, String details, int error) {
        super();
        this.error = error;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public int getError(){
        return error;
    }
}