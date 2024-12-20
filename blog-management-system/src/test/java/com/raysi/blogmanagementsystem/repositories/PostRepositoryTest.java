package com.raysi.blogmanagementsystem.repositories;

import com.raysi.blogmanagementsystem.entities.Post;
import com.raysi.blogmanagementsystem.entities.Tag;
import com.raysi.blogmanagementsystem.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void saveData(){

        List<Tag> tags = new ArrayList<>();
        Tag tag = Tag.builder()
                .name("tech")
                .build();
        Tag tag1 = Tag.builder()
                .name("ai")
                .build();
        tags.add(tag1);
        tags.add(tag);
        User user = User.builder()
                .name("Test1")
                .bio("Tester")
                .email("tester@gmail.com")
                .build();

        Post post = Post.builder()
                .title("Tech Journey")
                .content("A way of time")
                .user(user)
                .tags(tags)
                .build();

        postRepository.save(post);
    }

    @Test
    public void deletePost(){
        postRepository.deletePostById(13L);
    }

    @Test
    public void updateTitle(){
        String title = "Testing";
        Long id = 7L;
        postRepository.updateTitle(title, id);
    }
}