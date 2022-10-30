package com.example.client2service.connector.fallback;

import com.example.client2service.connector.BooksServiceUpdateConnector;
import com.example.client2service.model.Book;
import com.example.client2service.service.BooksService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceFallback {
    private final BooksServiceUpdateConnector booksServiceUpdateConnector;

    public BookServiceFallback(BooksServiceUpdateConnector booksServiceUpdateConnector) {
        this.booksServiceUpdateConnector = booksServiceUpdateConnector;
    }

    public List<Book> getAllBooks(){
    return booksServiceUpdateConnector.getAllBooks();
    }
}
