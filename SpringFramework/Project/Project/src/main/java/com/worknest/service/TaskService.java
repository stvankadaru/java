package com.worknest.service;

import com.worknest.dao.TaskDao;
import com.worknest.dao.UserDao;
import com.worknest.model.Task;
import com.worknest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private UserDao userDao;

    public List<Task> getAllTasks() {
        return taskDao.findAll();
    }

    public void saveTask(Task task) {
        taskDao.save(task);
    }

    public Task getTaskById(Long id) {
        return taskDao.findById(id);
    }

    public List<Task> getTasksByUser(Long userId) {
        User user = userDao.findById(userId);
        if (user != null) {
            return taskDao.findByUser(user);
        }
        return List.of();
    }

    public List<Task> getTasksByStatus(String status) {
        return taskDao.findByStatus(status);
    }
}
