package com.springboot.filter.controller;

import com.springboot.filter.exception.BadCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity welcomeHome()
    {
        return new ResponseEntity("Welcome", HttpStatus.PARTIAL_CONTENT);
    }

    @GetMapping("/home-pattern")
    public String welcomeHomePattern()
    {
        return "Welcome home pattern";
    }
}
