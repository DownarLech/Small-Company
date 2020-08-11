package com.example.demo.view.admin;

import com.example.demo.service.UserWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminRemoveWorkerController {

    @Autowired
    private UserWorkerService userWorkerService;

    @PostMapping("adminRemoveWorker")
    public ModelAndView adminRemoveWorkerPost(Integer userWorkerId){
        userWorkerService.removeWorker(userWorkerId);
        return new ModelAndView("redirect:adminWorkerList");
    }
}
