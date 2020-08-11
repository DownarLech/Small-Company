package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserManager;
import com.example.demo.model.UserRole;
import com.example.demo.model.UserWorker;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    private UserWorkerService userWorkerService;

    public boolean addNewUser(String firstName, String lastName, int role) {
        UserRole userRole = checkRole(role);
        if (userRole != null) {
            String login = generateLogin(userRole.toString().toLowerCase().charAt(0));

            if (login != null && login.charAt(0) == 'm') {
                User user = new User(null, firstName, lastName, login, generate4Numbers(), UserRole.MANAGER);
                userRepository.save(user);

                UserManager userManager = new UserManager(null, user);
                userManagerService.saveNewUserManager(userManager);
                return true;
            } else if (login != null && login.charAt(0) == 'w') {
                User user = new User(null, firstName, lastName, login, generate4Numbers(), UserRole.WORKER);
                userRepository.save(user);

                UserWorker userWorker = new UserWorker(null, user, new ArrayList<>());
                userWorkerService.addNewUserWorker(userWorker);
                return true;
            }
        }
        return false;
    }

    private UserRole checkRole(int role) {
        if (role == 1) {
            return UserRole.MANAGER;
        } else if (role == 2) {
            return UserRole.WORKER;
        }
        return null;
    }

    private int generate4Numbers() {
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    private String generateLogin(char startChar) {
        String login = "";

        int count = 0;
        while (count < 500) {
            login = "" + startChar + generate4Numbers();
            if (!checkForExist(login)) break;
            count++;
        }

        if (count < 500)
            return login;
        else
            return null;
    }

    private boolean checkForExist(String login) {
        char startChar = login.charAt(0);

        if (startChar == 'm' && userManagerService.findByLogin(login) == null) {
            return false;
        } else return !(startChar == 'w' && userWorkerService.findByLogin(login) == null);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login).isPresent() ? userRepository.findByLogin(login).get() : null;
    }
}
