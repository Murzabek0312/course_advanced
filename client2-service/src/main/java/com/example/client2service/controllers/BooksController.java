package com.example.client2service.controllers;

import com.example.client2service.model.Book;
import com.example.client2service.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksController {


@Autowired
private final BooksService booksService;



public BooksController(BooksService booksService) {
        this.booksService = booksService;
        }


@GetMapping( "/getAllBooksByFeignClient")
public List<Book> getAllData(){
        return booksService.getAllData();

        }
}
