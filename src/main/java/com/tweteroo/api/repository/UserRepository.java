package com.tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tweteroo.api.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    
    public List<UserModel> findByUsername(String username);
}
