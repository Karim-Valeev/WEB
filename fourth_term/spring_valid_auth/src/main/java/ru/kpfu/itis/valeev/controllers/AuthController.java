package ru.kpfu.itis.valeev.controllers;


import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.models.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.itis.valeev.services.UserService;

import java.io.FileWriter;
import java.io.IOException;
//
@Controller
@RequestMapping("/register")
public class AuthController  {

    @Autowired
    private UserService userService;

    //    FileWriter outputfile = new FileWriter("database.csv");
//
//    // create CSVWriter object filewriter object as parameter
//    CSVWriter writer = new CSVWriter(outputfile);
//
    public AuthController(UserService userService) throws IOException {
        this.userService= userService;
    }

//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setValidator(new UserValidator());
//    }

    @RequestMapping(value = "/new_user", method = RequestMethod.GET)
    public String newUser(ModelMap map) {
        map.put("user", new User());
        return "reg_form";
    }

    @RequestMapping(value = "/new_user", method = RequestMethod.POST)
    public String springHandler(
            @RequestParam String userName,
            @RequestParam String email,
            RedirectAttributes redirectAttributes,
            @Validated @ModelAttribute("user") User user,
            BindingResult result
    ) throws IOException {
        if (result.hasErrors()) {
            return "reg_form";
        } else {
            userService.writeUser(user);
            System.out.println(userName);
            System.out.println(email);
            System.out.println(user.getPassword());
            userService.writeUserCsv(user);
            redirectAttributes.addFlashAttribute("message", "<span style=\"color:green\">User \"" + user.getUserName() + "\" has been added successfully</span>");
            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("AC#newUser").build();
        }
    }
}
