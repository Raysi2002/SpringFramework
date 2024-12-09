package com.raysi.restapi.services;

import com.raysi.restapi.models.Books;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BooksService {
    List<Books> fetchBook();
    String postBook(Books book);
    String updateBook(Long id, Books book);
    boolean deleteBook(Long id);
}
