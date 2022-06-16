package com.springboot.interceptor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

@GetMapping("/badcred")
@ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String badCred()
{
    return "Incorrect user name and password";
}

}


