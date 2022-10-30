package com.example.bookserviceupdate.repositories;


import com.example.bookserviceupdate.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends MongoRepository<Book, String> {
}
