package ru.kpfu.itis.valeev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.valeev.models.Post;
import ru.kpfu.itis.valeev.models.User;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByOwner(User owner);
    Post findPostById(Long id);
    Post findPostByTitle(String title);
}
