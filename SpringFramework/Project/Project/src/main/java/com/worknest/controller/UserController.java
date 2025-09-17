package com.worknest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    // Show tasks assigned to logged-in user
    @GetMapping("/tasks")
    public String myTasks(HttpSession session, Model model) {
        User loggedIn = (User) session.getAttribute("loggedInUser");
        if (loggedIn == null) return "redirect:/login";

        List<Task> tasks = taskService.getTasksByUser(loggedIn.getId());
        model.addAttribute("tasks", tasks);
        return "user-tasks";
    }

    // Update status of a task
    @PostMapping("/updateTaskStatus")
    public String updateTaskStatus(@RequestParam Long id, @RequestParam String status) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            task.setStatus(status);
            taskService.saveTask(task);
        }
        return "redirect:/user/tasks";
    }

    // User dashboard
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        User loggedIn = (User) session.getAttribute("loggedInUser");
        if (loggedIn == null) return "redirect:/login";

        List<Task> tasks = taskService.getTasksByUser(loggedIn.getId());

        model.addAttribute("pending", tasks.stream().filter(t -> "PENDING".equals(t.getStatus())).toList());
        model.addAttribute("inProgress", tasks.stream().filter(t -> "IN_PROGRESS".equals(t.getStatus())).toList());
        model.addAttribute("completed", tasks.stream().filter(t -> "COMPLETED".equals(t.getStatus())).toList());
        model.addAttribute("delayed", tasks.stream().filter(t -> "DELAYED".equals(t.getStatus())).toList());

        return "user-dashboard";
    }
}
