package com.example.bookserviceupdate.service;


import com.example.bookserviceupdate.models.Book;
import com.example.bookserviceupdate.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {
    @Autowired
    private BooksRepository booksRepository;

    public List<Book> findAllBooks() {
        return booksRepository.findAll();
    }
}