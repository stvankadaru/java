package com.worknest.controller;

import com.worknest.model.Task;
import com.worknest.model.User;
import com.worknest.service.CommentService;
import com.worknest.service.TaskService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;
    private final TaskService taskService;
    public CommentController(CommentService cs, TaskService ts){ this.commentService = cs; this.taskService = ts; }

    @GetMapping("/{taskId}")
    public String page(@PathVariable int taskId, HttpSession session, Model model){
        User me = (User) session.getAttribute("loggedInUser");
        if (me == null) return "redirect:/login";
        Task task = taskService.getTaskById(taskId);
        if (task == null) return "redirect:/tasks/user";
        model.addAttribute("task", task);
        model.addAttribute("comments", commentService.forTask(task));
        return "user/comments";
    }

    @PostMapping("/{taskId}")
    public String add(@PathVariable int taskId, @RequestParam String content, HttpSession session){
        User me = (User) session.getAttribute("loggedInUser");
        if (me == null) return "redirect:/login";
        Task task = taskService.getTaskById(taskId);
        if (task == null) return "redirect:/tasks/user";
        commentService.add(task, me, content);
        return "redirect:/comments/" + taskId;
    }
}
