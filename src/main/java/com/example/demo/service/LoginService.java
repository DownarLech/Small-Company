package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginService {

    @Autowired
    private UserService userService;

    public String loggedLogin(HttpServletRequest request) {
        return (String) request.getSession().getAttribute("login");
    }

    public User login(HttpServletRequest request, String login, int password) {
        User user = userService.findByLogin(login);

        if (user != null && user.getPassword() == password)
            request.getSession().setAttribute("login", login);

        return user;
    }
}
