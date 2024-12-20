package com.raysi.blogmanagementsystem.services;

import com.raysi.blogmanagementsystem.entities.Post;
import com.raysi.blogmanagementsystem.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

    public List<Post> getPostById(Long id){
        return postRepository.findAllById(Collections.singleton(id));

    }

    public void deletePostById(Long id){
        postRepository.deletePostById(id);
    }

}
