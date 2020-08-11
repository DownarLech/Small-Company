package com.example.demo.service;

import com.example.demo.model.UserWorker;
import com.example.demo.repository.UserWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserWorkerService {

    @Autowired
    private UserWorkerRepository userWorkerRepository;

    public UserWorker findById(Integer userWorkerId) {
        return userWorkerRepository.findById(userWorkerId).isPresent() ? userWorkerRepository.findById(userWorkerId).get() : null;
    }

    public void removeWorker(Integer userWorkerId) {
        UserWorker userWorker = findById(userWorkerId);
        if (userWorker != null)
            userWorkerRepository.delete(userWorker);
    }

    public UserWorker findByLogin(String login){
        return userWorkerRepository.findByUserLogin(login).isPresent() ? userWorkerRepository.findByUserLogin(login).get() : null;
    }

    public void addNewUserWorker(UserWorker userWorker){
        userWorkerRepository.save(userWorker);
    }


}
