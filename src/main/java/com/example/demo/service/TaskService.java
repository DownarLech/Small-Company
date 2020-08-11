package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.model.UserWorker;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserWorkerService userWorkerService;

    public List<Task> findTaskListByUserWorkerId(Integer userWorkerId) {
        UserWorker userWorker = userWorkerService.findById(userWorkerId);
        return taskRepository.findAllByUserWorker(userWorker);
    }

    public List<Task> findTaskListByLogin(String login) {
        UserWorker userWorker = userWorkerService.findByLogin(login);
        return taskRepository.findAllByUserWorker(userWorker);
    }

    public Task findById(Integer taskId) {
        return taskRepository.findById(taskId).isPresent() ? taskRepository.findById(taskId).get() : null;
    }

    public void removeTask(Integer taskId) {
        Task task = findById(taskId);
        if (task != null)
            taskRepository.delete(task);
    }

    public boolean addNewTask(Integer userWorkerId, String topic, String deadline, String description) {
        UserWorker userWorker = userWorkerService.findById(userWorkerId);
        if (userWorker != null) {
            LocalDate date = LocalDate.parse(deadline);
            Task task = new Task(null, topic, date, false, description, userWorker);
            taskRepository.save(task);
            return true;
        }
        return false;
    }

    public void confirmEndTask(Integer taskId) {
        Task task = findById(taskId);
        if (task != null){
            task.setEnded(true);
            taskRepository.save(task);
        }
    }
}
