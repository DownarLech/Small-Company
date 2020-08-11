package com.example.demo.repository;

import com.example.demo.model.UserWorker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserWorkerRepository extends CrudRepository<UserWorker, Integer> {

    List<UserWorker> findAll();
    Optional<UserWorker> findByUserLogin(String login);
}
