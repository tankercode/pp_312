package com.tanker.springboottest.controller;

import com.tanker.springboottest.model.User;
import com.tanker.springboottest.service.UsersServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UsersServiceImp usersServiceImp;

    @GetMapping
    public String showUsersTable(Model model) {
        model.addAttribute("users", usersServiceImp.findAll());
        return "main";
    }

    @GetMapping(value = "/new")
    public String showCreateUserPage(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String createNewUser(@ModelAttribute("user") User user) {
        usersServiceImp.save(user);
        return "redirect:/";
    }

    @GetMapping(value = "/edit")
    public String showEditUserPage(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", usersServiceImp.findOne(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        usersServiceImp.update(id, user);
        return "redirect:/";
    }

    @GetMapping(value = "/delete")
    @DeleteMapping()
    public String delete(@RequestParam("id") int id) {
        usersServiceImp.deleteUserById(id);
        return "redirect:/";
    }

}
