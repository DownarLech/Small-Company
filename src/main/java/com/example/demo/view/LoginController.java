package com.example.demo.view;

import com.example.demo.model.User;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static com.example.demo.model.UserRole.ADMIN;
import static com.example.demo.model.UserRole.MANAGER;
import static com.example.demo.model.UserRole.WORKER;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("login")
    public ModelAndView loginGet() {
        return new ModelAndView("login");
    }

    @PostMapping("login")
    public ModelAndView loginPost(HttpServletRequest request, String login, int password) {
        User user = loginService.login(request, login, password);
        String address = "login";

        if (user != null) {
            switch (user.getUserRole()) {
                case ADMIN:
                    address = "adminManagerList";
                    break;
                case MANAGER:
                    address = "managerWorkerList";
                    break;
                case WORKER:
                    address = "workerTaskList";
                    break;
            }
        }
        return new ModelAndView("redirect:" + address);
    }
}
