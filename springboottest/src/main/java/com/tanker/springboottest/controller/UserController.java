package com.tanker.springboottest.controller;

import com.tanker.springboottest.models.User;
import com.tanker.springboottest.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UsersService usersService;

    @Autowired
    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String showUsersTable(Model model) {
        model.addAttribute("users", usersService.findAll());
        return "main";
    }

    @GetMapping(value = "/new")
    public String showCreateUserPage(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user) {
        usersService.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String showEditUserPage(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", usersService.findOne(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        usersService.update(id, user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    @DeleteMapping()
    public String delete(@RequestParam("id") int id) {
        usersService.deleteUserById(id);
        return "redirect:/";
    }

}
