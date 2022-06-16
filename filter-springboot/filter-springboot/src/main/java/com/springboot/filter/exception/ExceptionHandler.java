package com.springboot.filter.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public final ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex, WebRequest request) throws Exception {
        return ResponseEntity.of(Optional.of(ex.getMessage()));
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity handleAllException(Exception ex, WebRequest request) throws Exception {
        if(ex instanceof BadCredentialsException)
        {
            return new ResponseEntity(ex.getMessage(),HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
