package com.example.demo.view.manager;

import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerAddNewTaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("managerAddNewTask")
    public ModelAndView managerAddNewTaskGet(Integer userWorkerId, Model model) {
        model.addAttribute("userWorkerId", userWorkerId);
        return new ModelAndView("managerAddNewTask");
    }

    @PostMapping("managerAddNewTask")
    public ModelAndView managerAddNewTaskPost(Integer userWorkerId, String topic, String deadline, String description, Model model) {
        statusModel(taskService.addNewTask(userWorkerId, topic, deadline, description), userWorkerId, model);
        return new ModelAndView("managerAddNewTask");
    }

    private void statusModel(boolean success, Integer userWorkerId, Model model) {
        model.addAttribute("userWorkerId", userWorkerId);
        if (success) {
            model.addAttribute("message", "success");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "error");
            model.addAttribute("messageType", "danger");
        }
    }
}
