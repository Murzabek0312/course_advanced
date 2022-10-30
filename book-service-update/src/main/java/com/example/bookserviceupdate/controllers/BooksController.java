package com.example.bookserviceupdate.controllers;


import com.example.bookserviceupdate.models.Book;
import com.example.bookserviceupdate.service.BooksService;
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
    private BooksService booksService;

    private static final Logger LOG = Logger.getLogger(BooksController.class.getName());






    @GetMapping(path = "/show")
    public List<Book> getAllBooksList() {
        logger.info("Get data from database (Feign Client on client-service side)");
        return booksService.findAllBooks();
    }




}