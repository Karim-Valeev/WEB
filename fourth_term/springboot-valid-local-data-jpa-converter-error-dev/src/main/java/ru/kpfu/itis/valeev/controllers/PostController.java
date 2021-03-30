package ru.kpfu.itis.valeev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import ru.kpfu.itis.valeev.dto.PostForm;
import ru.kpfu.itis.valeev.exceptions.NotExistingPostException;
import ru.kpfu.itis.valeev.models.Post;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.services.PostService;
import ru.kpfu.itis.valeev.services.UserService;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private ServletContext context;
//    user with context.getContextPath()

    @ModelAttribute
    public void addAllPosts(Model model){
        model.addAttribute("posts", postService.getAllPosts());
    }

    @GetMapping(value = "/")
    public String getMainPage(Model model){
        model.addAttribute("postForm", new PostForm());
        return "index";
    }

    @GetMapping(value = "/posts")
    public  String getPostsPage(){
        return "all-posts";
    }

    @PostMapping(value = "/posts")
    public String addPost(
            Model model,
            @Valid PostForm postForm,
            BindingResult bindingResult
    ){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldErrors());
            model.addAttribute("postForm", postForm);
            return "index";
        } else {
            postService.addPost(postForm);
//            return "redirect:" + MvcUriComponentsBuilder.fromMappingName("BC#add").build();
            return "redirect:/posts";
        }

    }

    @GetMapping(value = "post/{postTitle}")
    public String getPostPage(
            @PathVariable String postTitle,
            Model model
    ){
        User user = userService.getUser(1L);
        List<Post> posts = postService.getAllPostsByOwner(user);
        try{
            Post post = postService.getPostByTitle(postTitle);

            model.addAttribute("title", post.getTitle());
            model.addAttribute("text", post.getText());
//        model.addAttribute("posts", posts);

            System.out.println(postTitle);
            return "post-page";
        }catch (NullPointerException ex){
            throw new NotExistingPostException("Post with that title don't exist", ex);
        }

    }

}
