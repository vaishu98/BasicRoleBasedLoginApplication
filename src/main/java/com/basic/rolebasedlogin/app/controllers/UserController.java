package com.basic.rolebasedlogin.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @GetMapping("/homepage")
    public ResponseEntity<String> userHomepage(){
        return new ResponseEntity<>("Welcome to User homepage!!", HttpStatus.OK);
    }
}
