package com.raysi.booksmanagement.services;

import com.raysi.booksmanagement.entities.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    public List<Books> showBooks();
    public String saveBook(Books books);
    public String updateBook(Long id, Books updatedBook);
    public String deleteBook(Long id);

}
