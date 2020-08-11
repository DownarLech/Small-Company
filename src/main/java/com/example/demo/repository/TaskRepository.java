package com.example.demo.repository;

import com.example.demo.model.Task;
import com.example.demo.model.UserWorker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findAllByUserWorker(UserWorker userWorker);
}
