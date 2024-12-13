package com.raysi.booksmanagement.controllers;


import com.raysi.booksmanagement.entities.Books;
import com.raysi.booksmanagement.services.BookService;
import com.raysi.booksmanagement.services.BooksServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    BooksServiceImplementation bookService;

    @GetMapping("/books")
    public List<Books> getBooks(){
        return bookService.showBooks();
    }

    @PostMapping("/post")
    public String saveBook(@RequestBody Books book){
        bookService.saveBook(book);
        return book.toString();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return "Deleted book successfully";
    }
}
