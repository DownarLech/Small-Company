package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitDataLoader {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAdminRepository userAdminRepository;

    @Autowired
    private UserManagerRepository userManagerRepository;

    @Autowired
    private UserWorkerRepository userWorkerRepository;

    @Autowired
    private TaskRepository taskRepository;

    @PostConstruct
    public void initialize() {
        User user = new User(null, "admin", "admin", "aaa", 111, UserRole.ADMIN);
        userRepository.save(user);
        UserAdmin admin = new UserAdmin(null, user);
        userAdminRepository.save(admin);

        user = new User(null, "manager1", "manager1", "mmm", 222, UserRole.MANAGER);
        userRepository.save(user);
        UserManager manager = new UserManager(null, user);
        userManagerRepository.save(manager);

        user = new User(null, "worker1", "worker1", "www", 333, UserRole.WORKER);
        userRepository.save(user);
        UserWorker worker = new UserWorker(null, user, new ArrayList<>());
        userWorkerRepository.save(worker);

        List<Task> taskList = new ArrayList<>();
        Task task = new Task(null, "topic1", LocalDate.now().plusDays(7), false, "description 1", worker);
        taskList.add(task);
        taskRepository.save(task);

        task = new Task(null, "topic2", LocalDate.now().plusDays(14), false, "description 2", worker);
        taskList.add(task);
        taskRepository.save(task);

        task = new Task(null, "topic3", LocalDate.now().plusDays(21), false, "description 3", worker);
        taskList.add(task);
        taskRepository.save(task);
    }
}
