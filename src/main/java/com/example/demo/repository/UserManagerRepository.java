package com.example.demo.repository;

import com.example.demo.model.UserManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserManagerRepository extends CrudRepository<UserManager, Integer> {

    List<UserManager> findAll();
    Optional<UserManager> findByUserLogin(String login);
}
