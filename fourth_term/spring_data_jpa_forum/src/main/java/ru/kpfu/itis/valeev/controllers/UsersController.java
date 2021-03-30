package ru.kpfu.itis.valeev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.services.UserService;

import java.util.List;

/**
 * 19.11.2020
 * 14. Web MVC Extended
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
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
