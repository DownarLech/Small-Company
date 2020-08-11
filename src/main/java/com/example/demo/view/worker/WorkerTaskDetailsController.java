package com.example.demo.view.worker;

import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkerTaskDetailsController {

    @Autowired
    private TaskService taskService;

    @GetMapping("workerTaskDetails")
    public ModelAndView workerTaskDetailsGet(Integer taskId, Model model) {
        setTaskModel(taskId, model);
        return new ModelAndView("workerTaskDetails");
    }

    private void setTaskModel(Integer taskId, Model model) {
        model.addAttribute("task", taskService.findById(taskId));
    }
}
