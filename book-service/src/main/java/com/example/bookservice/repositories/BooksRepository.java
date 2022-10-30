package com.example.bookservice.repositories;

import com.example.bookservice.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends MongoRepository<Book, String> {
}
