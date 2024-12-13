package com.raysi.booksmanagement.repositories;

import com.raysi.booksmanagement.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
