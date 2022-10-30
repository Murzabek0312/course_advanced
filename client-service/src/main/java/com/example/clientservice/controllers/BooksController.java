package com.example.clientservice.controllers;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController

public class BooksController {
    private final BooksService booksService;

    @Autowired
    private Environment env;

    @Autowired
    private static final Logger LOG = Logger.getLogger(BooksController.class.getName());

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping( "/getAllBooksByFeignClient")
    public List<Book> getAllBooks(){
    return booksService.getAllBooks();

    }

    @GetMapping("/getAllBooksByRestTemplate")
    public String data(){
    return booksService.data();
    }

    @RequestMapping("/")
    public String home(){return booksService.home();}

}
