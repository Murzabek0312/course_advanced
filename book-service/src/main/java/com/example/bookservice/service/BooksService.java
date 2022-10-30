package com.example.bookservice.service;

import com.example.bookservice.models.Book;
import com.example.bookservice.repositories.BooksRepository;
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