package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("api/auth/sign-up")
public class SignUp {
    
    @Autowired
    private UserService service;

    @PostMapping
    public void create(@RequestBody UserDTO data) {
        
        service.create(data);
    }

}
