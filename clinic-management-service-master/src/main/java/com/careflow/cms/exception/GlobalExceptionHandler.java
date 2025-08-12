package com.careflow.cms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DoctorNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ProblemDetail handleDoctorNotFoundException(DoctorNotFoundException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setTitle("Doctor Not Found");
        problemDetail.setProperty("reason",ex.getMessage());
        problemDetail.setProperty("severity","ERROR");
        return problemDetail;
    }
}
