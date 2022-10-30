package com.example.bookservice.controllers;

import com.example.bookservice.models.Book;
import com.example.bookservice.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")

public class BooksController {
    Logger logger = Logger.getLogger(BooksController.class.getName());
    @Autowired
    private Environment env;
    @Autowired
    private  BooksService booksService;

    private static final Logger LOG = Logger.getLogger(BooksController.class.getName());




    @RequestMapping("/")
    public String home() {
        String home = "Book-Service running at port: " + env.getProperty("local.server.port");
//        logger.info(home);
        LOG.log(Level.INFO, home);
        return home;
    }

    @GetMapping(path = "/show")
    public List<Book> getAllBooksList() {
        logger.info("Get data from database (Feign Client on client-service side)");
        return booksService.findAllBooks();
    }

    @GetMapping("/data")
    public List<Book> data() {
        logger.info("Get data from database (RestTemplate on client-service side)");
        return booksService.findAllBooks();
    }




}