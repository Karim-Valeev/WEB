package ru.kpfu.itis.valeev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.valeev.dto.WebsiteDto;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.models.Website;
import ru.kpfu.itis.valeev.services.UserService;
import ru.kpfu.itis.valeev.services.WebsiteService;

import javax.servlet.ServletContext;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private WebsiteService websiteService;

    @Autowired
    private ServletContext context;

    public AdminController(UserService userService, WebsiteService websiteService) {
        this.userService = userService;
        this.websiteService = websiteService;
    }

    @GetMapping(value = "/")
    public String getMainPage() {
        return "main";
    }

    @GetMapping(value = "/adminka")
    public String getAdminPage() {
        return "adminka";
    }

    @PostMapping (value = "/adminka")
    public String saveWebsite(
            @RequestParam  String title,
            @RequestParam String parent_url,
            @RequestParam  String html_body
    ) {
        System.out.println(title);
        System.out.println(parent_url);
        System.out.println(html_body);

//        Todo get name from HttpSession
        String login = "admin";
        User user = userService.getUserById(1L);
        WebsiteDto websiteDto = new WebsiteDto(user, title, parent_url, html_body);
        websiteService.addWebsite(websiteDto);
        return "redirect:" + context.getContextPath() + "/adminka";
    }

    @GetMapping(value = "/websites/{websiteUrl}")
    public String getWebsite(
            @PathVariable String websiteUrl,
            Model model) {
//        System.out.println(websiteUrl);
//        return websiteUrl;
        Website website = websiteService.getWebsite(websiteUrl);
        model.addAttribute("title", website.getTitle());
        model.addAttribute("htmlBody", website.getBody());
        return "user-website";
    }


}
