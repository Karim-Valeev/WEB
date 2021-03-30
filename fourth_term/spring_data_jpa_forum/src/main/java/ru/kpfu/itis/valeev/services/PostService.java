package ru.kpfu.itis.valeev.services;

import ru.kpfu.itis.valeev.models.Post;
import ru.kpfu.itis.valeev.models.User;

import java.util.List;

public interface PostService {
    void addPost(Post post);
    List<Post> getAllPosts();
    List<Post> getAllPostsByOwner(User owner);
    Post getPostById(Long id);
    Post getPostByTitle(String title);
}
