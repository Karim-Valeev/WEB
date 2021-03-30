package ru.kpfu.itis.valeev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.itis.valeev.models.Post;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.services.PostService;
import ru.kpfu.itis.valeev.services.UserService;

import javax.servlet.ServletContext;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private ServletContext context;

    @GetMapping(value = "/posts")
    public  String getPostsPage(){
        return "index";
    }

    @PostMapping(value = "/posts")
    public String addPost(
            @RequestParam String title,
            @RequestParam String text

    ){
        Post post = new Post(title, text);
        postService.addPost(post);
        return "redirect:" + context.getContextPath() + "/post-page";
    }

    @GetMapping(value = "post/{postTitle}")
    public String getPostPage(
            @PathVariable String postTitle,
            Model model
    ){
        User user = userService.getUser(1L);
        List<Post> posts = postService.getAllPostsByOwner(user);
        Post post = postService.getPostByTitle(postTitle);

        model.addAttribute("title", post.getTitle());
        model.addAttribute("text", post.getText());
        model.addAttribute("posts", posts);

        System.out.println(postTitle);
        return "post-page";
    }

    @GetMapping(value = "all_posts")
    public String getAllPostsPage(){

        return "all-posts";
    }

}
