package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    public void create(TweetDTO data) {
        repository.save(new Tweet(data));
    }

    public List<Tweet> getAllTweetsByUsername(String username) {

        return repository.findByUsername(username);
    }

    public Page<Tweet> findAll(int page) {
        PageRequest pageRequest = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        
        return repository.findAll(pageRequest);

        //return repository.findByOrderByIdDesc();
    }

    // public Page<Tweet> findAll(int page) {
    //     PageRequest pageRequest = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
    //     return repository.findAll(pageRequest);
    // }
}
