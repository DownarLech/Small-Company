package com.example.demo.view.worker;

import com.example.demo.service.LoginService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WorkerTaskListController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private LoginService loginService;

    @GetMapping("workerTaskList")
    public ModelAndView workerTaskListGet(HttpServletRequest request, Model model) {
        setTaskListModel(request, model);
        return new ModelAndView("workerTaskList");
    }

    private void setTaskListModel(HttpServletRequest request, Model model) {
        String login = loginService.loggedLogin(request);
        model.addAttribute("taskList", taskService.findTaskListByLogin(login));
    }
}
