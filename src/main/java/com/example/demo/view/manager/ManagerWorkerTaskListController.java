package com.example.demo.view.manager;

import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerWorkerTaskListController {

    @Autowired
    private TaskService taskService;

    @GetMapping("managerWorkerTaskList")
    public ModelAndView managerWorkerTaskListGet(Integer userWorkerId, Model model) {
        setWorkerTaskListModel(userWorkerId, model);
        return new ModelAndView("managerWorkerTaskList");
    }

    private void setWorkerTaskListModel(Integer workerId, Model model) {
        model.addAttribute("userWorkerId", workerId);
        model.addAttribute("taskList", taskService.findTaskListByUserWorkerId(workerId));
    }
}
