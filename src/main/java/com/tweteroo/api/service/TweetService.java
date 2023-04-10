package com.tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.UserModel;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public void create(TweetDTO data) {

        List<UserModel> users = userRepository.findByUsername(data.username());
        

        if (users.isEmpty()) {
            System.out.println("deu ruim !!!!!");
        }

        Tweet newTweet = new Tweet(data, users.get(0).getAvatar());
        repository.save(newTweet);
    }

    public List<Tweet> getAllTweetsByUsername(String username) {

        return repository.findByUsername(username);
    }

    public Page<Tweet> findAll(int page) {
        PageRequest pageRequest = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        
        return repository.findAll(pageRequest);
    }
}
