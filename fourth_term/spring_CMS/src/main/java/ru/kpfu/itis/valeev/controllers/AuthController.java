package ru.kpfu.itis.valeev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.services.UserService;

import java.io.IOException;
import java.sql.SQLException;

@Controller
//@RequestMapping("/register")
public class AuthController  {

    @Autowired
    private UserService userService;

    public AuthController(UserService userService) throws IOException {
        this.userService= userService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String reg(ModelMap map) {
        return "reg_form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            @RequestParam String login,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String bio,
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute("user") User user,
            BindingResult result
    ) throws IOException, SQLException, ClassNotFoundException {
        if (result.hasErrors()) {
            return "reg_form";
        } else {
            User newUser = new User(login,email,password);
            userService.addUser(newUser);
            return "profile";
        }
    }


}
