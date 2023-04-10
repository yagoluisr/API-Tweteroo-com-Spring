package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tweteroo.api.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long>{
    public List<Tweet> findByUsername(String username);

    @Query("FROM Tweet tweet WHERE tweet.username = :username")
    public List<Tweet> findByUsernameEquals(@Param("username") String username);
}
