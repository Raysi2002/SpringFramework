package com.raysi.blogmanagementsystem.repositories;

import com.raysi.blogmanagementsystem.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
