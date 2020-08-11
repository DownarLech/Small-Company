package com.example.demo.view.admin;

import com.example.demo.repository.UserWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminWorkerListController {

    @Autowired
    private UserWorkerRepository userWorkerRepository;

    @GetMapping("adminWorkerList")
    public ModelAndView userListGet(){
        return new ModelAndView("adminWorkerList", "workerList", userWorkerRepository.findAll());
    }
}
