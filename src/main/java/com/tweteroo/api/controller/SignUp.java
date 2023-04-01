package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.UserRepository;

@RestController
@RequestMapping("/sign-up")
public class SignUp {
    
    @Autowired
    private UserRepository repository;

    @GetMapping
    public String test() {
        return "Deu bom !";
    }

    @PostMapping
    public void create(@RequestBody UserDTO data) {
        
        repository.save(new UserModel(data));
    }

}
