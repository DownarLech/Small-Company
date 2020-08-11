package com.example.demo.service;

import com.example.demo.model.UserManager;
import com.example.demo.repository.UserManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagerService {

    @Autowired
    private UserManagerRepository userManagerRepository;

    public UserManager findById(Integer userManagerId) {
        return userManagerRepository.findById(userManagerId).isPresent() ? userManagerRepository.findById(userManagerId).get() : null;
    }

    public void removeManager(Integer userManagerId) {
        UserManager userManager = findById(userManagerId);
        if (userManager != null)
            userManagerRepository.delete(userManager);
    }

    public UserManager findByLogin(String login){
        return userManagerRepository.findByUserLogin(login).isPresent() ? userManagerRepository.findByUserLogin(login).get() : null;
    }

    public void saveNewUserManager(UserManager userManager){
        userManagerRepository.save(userManager);
    }
}
