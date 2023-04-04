package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.service.TweetService;


@RestController
@RequestMapping("/tweets")
public class Tweets {

    @Autowired
    private TweetService service;
    
    @GetMapping
    public String test() {
        return "Deu certo !";
    }

    @PostMapping
    public void postTweet(@RequestBody TweetDTO data) {

        service.create(data);
    }
}
