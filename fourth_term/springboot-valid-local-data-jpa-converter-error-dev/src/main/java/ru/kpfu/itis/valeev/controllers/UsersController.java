package ru.kpfu.itis.valeev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.services.UserService;


@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String getUsersPage(@RequestParam(value = "page", required = false) Integer page,
                               @RequestParam(value = "size", required = false) Integer size,
                               Model model) {
        if (page != null && size != null) {
            model.addAttribute("users", userService.getAllUsers(page, size));
        } else {
            model.addAttribute("users", userService.getAllUsers());
        }
        return "users_view";
    }

    @PostMapping(value = "/users")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

}
