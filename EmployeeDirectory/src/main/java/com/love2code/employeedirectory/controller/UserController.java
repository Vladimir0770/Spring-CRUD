package com.love2code.employeedirectory.controller;

import com.love2code.employeedirectory.entity.User;
import com.love2code.employeedirectory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String showUsers(Model model) {

        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "home";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "user-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);

        return "redirect:/users/list";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam Long id, Model model) {

        Optional<User> user = userService.findById(id);
        model.addAttribute("user", user);

        return "user-form";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam Long id) {

        userService.deleteById(id);

         return "redirect:/users/list";
    }
}
