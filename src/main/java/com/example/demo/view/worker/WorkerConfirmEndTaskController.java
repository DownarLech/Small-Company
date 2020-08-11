package com.example.demo.view.worker;

import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WorkerConfirmEndTaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("workerConfirmEndTask")
    public ModelAndView workerConfirmEndTaskPost(Integer taskId) {
        confirmEndTask(taskId);
        return new ModelAndView("redirect:workerTaskDetails", "taskId", taskId);
    }

    private void confirmEndTask(Integer taskId) {
        taskService.confirmEndTask(taskId);
    }
}
