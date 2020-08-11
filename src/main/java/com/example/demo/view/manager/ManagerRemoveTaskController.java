package com.example.demo.view.manager;

import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerRemoveTaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("managerRemoveTask")
    public ModelAndView managerRemoveTask(Integer userWorkerId, Integer taskId) {
        taskService.removeTask(taskId);
        return new ModelAndView("redirect:managerWorkerTaskList", "userWorkerId", userWorkerId);
    }
}
