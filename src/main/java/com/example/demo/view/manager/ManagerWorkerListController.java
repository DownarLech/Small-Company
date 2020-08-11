package com.example.demo.view.manager;

import com.example.demo.repository.UserWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerWorkerListController {

    @Autowired
    private UserWorkerRepository userWorkerRepository;

    @GetMapping("managerWorkerList")
    public ModelAndView managerWorkerListGet(){
        return new ModelAndView("managerWorkerList", "workerList", userWorkerRepository.findAll());
    }
}
