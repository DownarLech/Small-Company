package com.example.demo.view.admin;

import com.example.demo.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminRemoveManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @PostMapping("adminRemoveManger")
    public ModelAndView adminRemoveMangerPost(Integer userManagerId){
        userManagerService.removeManager(userManagerId);
        return new ModelAndView("redirect:adminManagerList");
    }
}
