package com.example.demo.view.manager;

import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerTaskDetailsController {

    @Autowired
    private TaskService taskService;

    @GetMapping("managerTaskDetails")
    public ModelAndView managerTaskDetailsGet(Integer userWorkerId, Integer taskId, Model model) {
        setBasicModel(userWorkerId, taskId, model);
        return new ModelAndView("managerTaskDetails");
    }

    private void setBasicModel(Integer userWorkerId, Integer taskId, Model model) {
        model.addAttribute("userWorkerId", userWorkerId);
        model.addAttribute("task", taskService.findById(taskId));
    }
}
