package ru.kpfu.itis.valeev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.valeev.models.Post;
import ru.kpfu.itis.valeev.models.User;
import ru.kpfu.itis.valeev.repositories.PostRepository;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllPostsByOwner(User owner) {
        return postRepository.findAllByOwner(owner);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findPostById(id);
    }

    @Override
    public Post getPostByTitle(String title) {
        return postRepository.findPostByTitle(title);
    }
}
