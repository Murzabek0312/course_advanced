package com.example.client2service.connector.fallback;

import com.example.client2service.connector.BooksServiceUpdateConnector;
import com.example.client2service.model.Book;
import com.example.client2service.service.BooksService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Component
public class BookServiceFallback {
    private final BooksServiceUpdateConnector booksServiceUpdateConnector;
    Logger logger = Logger.getLogger(BookServiceFallback.class.getName());

    public BookServiceFallback(BooksServiceUpdateConnector booksServiceUpdateConnector) {
        this.booksServiceUpdateConnector = booksServiceUpdateConnector;
    }

    public List<Book> getAllBooks(){
        logger.info("Calling throw Feign client FallBack");
        return booksServiceUpdateConnector.getAllBooks();
    }
}
