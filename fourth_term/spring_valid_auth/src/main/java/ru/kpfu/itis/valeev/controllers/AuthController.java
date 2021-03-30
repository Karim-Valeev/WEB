package ru.kpfu.itis.valeev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Soundbank;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Map;

@Controller
public class AuthController  {

//    ToDO validation
//    Todo посмотреть видосы и голосовухи, что такое локализация

    @Autowired
    private UserService userService;

    public AuthController(UserService userService) throws IOException {
        this.userService= userService;
    }

//    @InitBinder
//    private void initBinder(WebDataBinder binder) {
//        binder.setValidator(new UserValidator());
//    }

    //    Homework № 2
    @RequestMapping(
            value = "/method_headers",
            headers = "user-agent=Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36"
//            ,params = "my_param=1"
    )
    public String methodHeadersPrinter(@RequestHeader Map<String, String> headers, Model model){
        model.addAttribute("map", headers);
        System.out.println(headers.entrySet());
        return "method-headers";
    }

    @GetMapping(value = "/")
    public String mainPage(){
        return "main";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String reg(ModelMap map) {
        return "reg_form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(
            HttpServletRequest req,
            @RequestParam String login,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String bio,
            Model model
//            ,
//            RedirectAttributes redirectAttributes,
//            @Validated @ModelAttribute("user") User user,
//            BindingResult result
    ) throws IOException, SQLException, ClassNotFoundException {
//        if (result.hasErrors()) {
//            return "reg_form";
//        } else {
//
////            Todo собрать юзера по полям
////            Todo юзера закинуть в сервис
//
//        }
        login = req.getParameter("login");
        email = req.getParameter("email");
        password = req.getParameter("password");
        bio = req.getParameter("bio");

        System.out.println(login +" "+ email+" " + bio);

        User newUser = new User(login,email,password,bio);
        System.out.println(newUser);

        userService.addUser(newUser);

        model.addAttribute("user", newUser);

        return "profile";
    }
}
