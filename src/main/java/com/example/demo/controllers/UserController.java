package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String Registration(Model model) {
        return "user/registration";
    }

    @PostMapping("/registration")
    public String Register(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
        User user = new User(username, email, password);
        userRepository.save(user);
        return "redirect:/blog";
    }
}
