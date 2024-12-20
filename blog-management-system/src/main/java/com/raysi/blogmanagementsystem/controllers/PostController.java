package com.raysi.blogmanagementsystem.controllers;

import com.raysi.blogmanagementsystem.entities.Post;
import com.raysi.blogmanagementsystem.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    //Getting all the post from the database
    @GetMapping("/api/posts")
    public List<Post> getAllPosts(){
        return postService.getAllPost();
    }

    @GetMapping("/api/posts/{id}")
    public List<Post> getPostById(@PathVariable Long id){
        return postService.getPostById(id);
    }

    @PostMapping("/api/posts")
    public String publishPost(@RequestBody Post post){
        postService.savePost(post);
        return "Post published successfully!";
    }

    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePostById(id);
        return "Post deleted successfully";
    }
}
