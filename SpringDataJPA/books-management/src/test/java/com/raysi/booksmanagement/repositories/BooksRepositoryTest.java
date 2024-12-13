package com.raysi.booksmanagement.repositories;

import com.raysi.booksmanagement.entities.Author;
import com.raysi.booksmanagement.entities.Books;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BooksRepositoryTest {

    @Autowired
    private BooksRepository booksRepository ;

    @Test
    public void saveBooks(){

        Author author = Author.builder()
                .authorName("Aashish")
                .email("2002raysi@gmail.com")
                .phone("9848278176")
                .build();
        Books books = Books.builder()
                .bookName("Our Journey")
                .author(author)
                .genre("Love Story")
                .build();
        booksRepository.save(books);
    }
}