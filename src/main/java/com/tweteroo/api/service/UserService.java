package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public void create(UserDTO data) {
        repository.save(new UserModel(data));
    }


} 
