package com.raysi.restapi.controllers;

import com.raysi.restapi.models.Books;
import com.raysi.restapi.services.BookServiceImplementation;
import com.raysi.restapi.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BooksService booksService;


    @GetMapping("/books")
    public List<Books> fetchBook(){
        return booksService.fetchBook();
    }

    @PostMapping("/postbook")
    String postBook(@RequestBody Books book){
        booksService.postBook(book);
        return book.toString();
    }

    @PutMapping("/update/{id}")
    String updateBook(@PathVariable Long id, @RequestBody Books bk){
        booksService.updateBook(id, bk);
        return bk.toString();
    }

    @DeleteMapping("/delete/{id}")
    String deleteBook(@PathVariable Long id){
        if(booksService.deleteBook(id))
            return "Book deleted successfully";
        return "Book with id: " + id + " not found";
    }
}
