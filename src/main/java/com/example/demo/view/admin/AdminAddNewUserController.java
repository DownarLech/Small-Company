package com.example.demo.view.admin;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminAddNewUserController {

    @Autowired
    private UserService userService;

    @GetMapping("adminAddNewUser")
    public ModelAndView adminAddNewUser(){
        return new ModelAndView("adminAddNewUser");
    }

    @PostMapping("adminAddNewUser")
    public ModelAndView adminAddNewUserPost(String firstName, String lastName, int role) {
        return new ModelAndView("adminAddNewUser", statusModel(userService.addNewUser(firstName, lastName, role)));
    }

    private Map<String, String> statusModel(boolean success) {
        Map<String, String> statusMap = new HashMap<>();

        if (success) {
            statusMap.put("message", "success");
            statusMap.put("messageType", "success");
        } else {
            statusMap.put("message", "error");
            statusMap.put("messageType", "danger");
        }
        return statusMap;
    }
}
