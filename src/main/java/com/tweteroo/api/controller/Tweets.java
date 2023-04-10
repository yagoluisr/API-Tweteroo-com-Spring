package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetService;

@CrossOrigin
@RestController
@RequestMapping("api/tweets")
public class Tweets {

    @Autowired
    private TweetService service;
    
    @GetMapping
    public Page<Tweet> test(@RequestParam int page) {
                       
        return service.findAll(page);
    }

    @GetMapping("/{username}")
    public List<Tweet> getAllByUsername(@PathVariable String username) {

        return service.getAllTweetsByUsername(username);
    }

    @PostMapping
    public void postTweet(@RequestBody TweetDTO data) {
        System.out.println(data);

try {
    service.create(data);
} catch (Exception e) {
    // TODO: handle exception
}

        
    }
}
