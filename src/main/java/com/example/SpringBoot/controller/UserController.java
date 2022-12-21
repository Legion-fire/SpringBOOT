package com.example.SpringBoot.controller;


import com.example.SpringBoot.model.User;
import com.example.SpringBoot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam ("id") Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/user";
    }


    @GetMapping("/new")
    public String addUser(@ModelAttribute("user") User user) {
        return "users/new";
    }

    @PostMapping()
    public String add(@ModelAttribute ("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }


    @GetMapping("/edit")
    public String edit (@RequestParam ("id") Long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "users/edit";
    }

    @PostMapping("/edit")
    public String update(@RequestParam ("id") Long id, User user) {
        user.setUserId(id);
        userService.save(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

}
