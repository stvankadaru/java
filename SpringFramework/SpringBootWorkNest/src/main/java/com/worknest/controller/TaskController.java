package com.worknest.controller;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.TaskService;
import com.worknest.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    public TaskController(TaskService ts, UserService us){ this.taskService = ts; this.userService = us; }

    // USER: list their tasks
    @GetMapping("/user")
    public String userTasks(HttpSession session, Model model){
        User me = (User) session.getAttribute("loggedInUser");
        if (me == null) return "redirect:/login";
        model.addAttribute("tasks", taskService.getTasksByUser(me.getId()));
        return "user/tasks";
    }

    // USER: update status (In Progress / Completed)
    @PostMapping("/user/{taskId}/status")
    public String updateMyTaskStatus(@PathVariable int taskId, @RequestParam String status, HttpSession session){
        if (session.getAttribute("loggedInUser") == null) return "redirect:/login";
        taskService.updateStatus(taskId, status);
        return "redirect:/tasks/user";
    }

    // ADMIN: dashboard
    @GetMapping("/admin/dashboard")
    public String dashboard(HttpSession session, Model model){
        User me = (User) session.getAttribute("loggedInUser");
        if (me == null) return "redirect:/login";
        if (!"ADMIN".equalsIgnoreCase(me.getRole())) return "redirect:/tasks/user";
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("users", userService.all());
        return "admin/dashboard";
    }

    // ADMIN: show create
    @GetMapping("/admin/create")
    public String showCreate(HttpSession session, Model model){
        User me = (User) session.getAttribute("loggedInUser");
        if (me == null) return "redirect:/login";
        if (!"ADMIN".equalsIgnoreCase(me.getRole())) return "redirect:/tasks/user";
        model.addAttribute("users", userService.all());
        return "admin/create-task";
    }

    // ADMIN: create with multi-user assignment (same task id)
    @PostMapping("/admin/create")
    public String create(@RequestParam String title, @RequestParam String description,
                         @RequestParam Date startDate, @RequestParam Date dueDate,
                         @RequestParam(name="userIds", required=false) List<Integer> userIds,
                         HttpSession session){
        User me = (User) session.getAttribute("loggedInUser");
        if (me == null) return "redirect:/login";
        if (!"ADMIN".equalsIgnoreCase(me.getRole())) return "redirect:/tasks/user";
        taskService.allocateGroupTask(title, description, startDate, dueDate, userIds);
        return "redirect:/tasks/admin/dashboard";
    }

    // ADMIN: delete
    @GetMapping("/admin/delete/{id}")
    public String delete(@PathVariable int id, HttpSession session){
        User me = (User) session.getAttribute("loggedInUser");
        if (me == null) return "redirect:/login";
        if (!"ADMIN".equalsIgnoreCase(me.getRole())) return "redirect:/tasks/user";
        taskService.deleteTask(id);
        return "redirect:/tasks/admin/dashboard";
    }
}
