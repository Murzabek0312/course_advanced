package com.example.client2service.connector;


import com.example.client2service.config.FeignConfig;
import com.example.client2service.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(
        name = "book-service-update",
        url = "${service-book-update.url}",
        configuration = FeignConfig.class
)
public interface BooksServiceUpdateConnector {

    @GetMapping("/show")
    public List<Book> getAllBooks();

}
