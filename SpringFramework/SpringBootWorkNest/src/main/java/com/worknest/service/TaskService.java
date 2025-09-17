// com/worknest/service/TaskService.java
package com.worknest.service;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.repository.TaskRepository;
import com.worknest.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service @Transactional
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository tr, UserRepository ur){ this.taskRepository = tr; this.userRepository = ur; }

    // Create one task and assign to multiple users → SAME TASK ID
    public Task allocateGroupTask(String title, String description, Date start, Date due, List<Integer> userIds){
        Task t = new Task();
        t.setTitle(title);
        t.setDescription(description);
        t.setStartDate(start);
        t.setDueDate(due);
        t.setStatus("PENDING");
        t.setUsers(userRepository.findAllById(userIds));
        return taskRepository.save(t);
    }

    public void updateTask(int taskId, String title, String description, String status, Date start, Date due, List<Integer> userIds){
        Optional<Task> opt = taskRepository.findById(taskId);
        opt.ifPresent(t -> {
            t.setTitle(title); t.setDescription(description); t.setStatus(status);
            t.setStartDate(start); t.setDueDate(due);
            t.setUsers(userRepository.findAllById(userIds));
            taskRepository.save(t);
        });
    }

    public void updateStatus(int taskId, String status){
        taskRepository.findById(taskId).ifPresent(t -> { t.setStatus(status); taskRepository.save(t); });
    }

    public void deleteTask(int id){ taskRepository.deleteById(id); }
    public Task getTaskById(int id){ return taskRepository.findById(id).orElse(null); }
    public List<Task> getAllTasks(){ return taskRepository.findAll(); }

    // For a specific user
    public List<Task> getTasksByUser(int userId){
        return userRepository.findById(userId).map(taskRepository::findByUsers).orElse(List.of());
    }
}
