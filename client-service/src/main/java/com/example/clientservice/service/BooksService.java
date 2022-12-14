package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BooksService {


//    @Autowired
    private BookServiceConnector bookServiceConnector;
//    @Autowired
    private RestTemplate restTemplate;
//    @Autowired
//
//    private RestTemplate loadBalanced;

    private static final Logger LOG = Logger.getLogger(BooksService.class.getName());

    public BooksService(BookServiceConnector bookServiceConnector, RestTemplate restTemplate) {
        this.bookServiceConnector = bookServiceConnector;
        this.restTemplate = restTemplate;
//        this.loadBalanced = loadBalanced;

    }


    public List<Book> getAllBooks() {
        return bookServiceConnector.getAllBooks();
    }


    @HystrixCommand(fallbackMethod = "failed")
    public String data() {
        String response = restTemplate.getForObject("http://localhost:8081/data", String.class);
        LOG.log(Level.INFO, String.valueOf(response));
        return response;
    }

    public String home() {
        String response = restTemplate.getForObject("http://localhost:8081/", String.class);
        return response;
    }


    public String failed() {
        String error = "Service is not available now. Please try again later";
        LOG.log(Level.INFO, error);
        return error;
    }


}
