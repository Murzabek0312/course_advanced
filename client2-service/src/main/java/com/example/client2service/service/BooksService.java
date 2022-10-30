package com.example.client2service.service;

import com.example.client2service.connector.BooksServiceConnector;
import com.example.client2service.connector.BooksServiceUpdateConnector;
import com.example.client2service.connector.fallback.BookServiceFallback;
import com.example.client2service.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    private final BooksServiceConnector booksServiceConnector;

    private final BookServiceFallback bookServiceFallback;


    public BooksService(BooksServiceConnector booksServiceConnector, BookServiceFallback bookServiceFallback, BooksServiceUpdateConnector booksServiceUpdateConnector) {
        this.booksServiceConnector = booksServiceConnector;
        this.bookServiceFallback = bookServiceFallback;
    }

    @HystrixCommand(fallbackMethod = "fail")
    public List<Book> getAllData(){
        return booksServiceConnector.getAllBooks();
    }

    public List<Book> fail(){
        return bookServiceFallback.getAllBooks();
    }




}
