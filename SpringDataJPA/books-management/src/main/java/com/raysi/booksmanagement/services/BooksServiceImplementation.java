package com.raysi.booksmanagement.services;

import com.raysi.booksmanagement.entities.Books;
import com.raysi.booksmanagement.repositories.BooksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImplementation implements BookService{
    private final BooksRepository booksRepository;

    public BooksServiceImplementation(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Books> showBooks() {
//        List<Books> books = booksRepository.findAll();
        return booksRepository.findAll();
    }

    @Override
    public String saveBook(Books books) {
        booksRepository.save(books);
        return "Book saved successfully";
    }

    @Override
    public String updateBook(Long id, Books updatedBook) {
        return "";
    }

    @Override
    public String deleteBook(Long id) {
        booksRepository.deleteById(id);
        return "book deleted successfully";
    }
}