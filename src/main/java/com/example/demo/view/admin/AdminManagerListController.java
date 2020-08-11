package com.example.demo.view.admin;

import com.example.demo.repository.UserManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminManagerListController {

    @Autowired
    private UserManagerRepository userManagerRepository;

    @GetMapping("adminManagerList")
    public ModelAndView adminManagerList() {
        return new ModelAndView("adminManagerList", "managerList", userManagerRepository.findAll());
    }
}
