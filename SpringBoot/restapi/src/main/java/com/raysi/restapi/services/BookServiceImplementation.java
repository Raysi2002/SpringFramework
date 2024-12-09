package com.raysi.restapi.services;

import com.raysi.restapi.models.Books;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImplementation implements BooksService{

    List<Books> booksList = new ArrayList<>();
    @Override
    public List<Books> fetchBook() {
        return booksList;
    }

    @Override
    public String postBook(Books book) {
        booksList.add(book);
        return "book added successfully";
    }

    @Override
    public String updateBook(Long id, Books updatedBook) {
        for(Books bk : booksList){
            if(bk.getId() == id){
                bk.setAuthor(updatedBook.getAuthor());
                bk.setName(updatedBook.getName());
                bk.setPrice(updatedBook.getPrice());
                return "Book updated successfully" + updatedBook;
            }
        }
        return "Book with id: " + id + " not found";
    }

    @Override
    public boolean deleteBook(Long id) {
        boolean removed = booksList.removeIf(bk -> bk.getId().equals(id));
        return removed;
    }
}
