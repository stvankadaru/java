package com.worknest.controller;

import com.worknest.model.User;
import com.worknest.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){ this.userService = userService; }

    // Redirect root
    @GetMapping("/")
    public String home(HttpSession session){
        return (session.getAttribute("loggedInUser") == null) ? "redirect:/login" : "redirect:/tasks/user";
    }

    @GetMapping("/login") public String loginPage(){ return "login"; }

    @PostMapping("/login")
    public String doLogin(@RequestParam String email, @RequestParam String password,
                          HttpSession session, Model model){
        User user = userService.login(email, password);
        if (user == null){
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
        session.setAttribute("loggedInUser", user);
        return "ADMIN".equalsIgnoreCase(user.getRole()) ? "redirect:/tasks/admin/dashboard" : "redirect:/tasks/user";
    }

    @GetMapping("/register") public String registerPage(){ return "register"; }

    @PostMapping("/register")
    public String register(@RequestParam String name, @RequestParam String email,
                           @RequestParam String password){
        User u = new User(); u.setName(name); u.setEmail(email); u.setPassword(password); u.setRole("USER");
        userService.register(u);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
