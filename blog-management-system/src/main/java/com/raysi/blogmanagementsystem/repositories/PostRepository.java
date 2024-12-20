package com.raysi.blogmanagementsystem.repositories;

import com.raysi.blogmanagementsystem.entities.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from post p where p.post_id  = :id", nativeQuery = true)
    void deletePostById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update post set title = :title where post_id = :id", nativeQuery = true)
    void updateTitle(String title, Long id);
}
