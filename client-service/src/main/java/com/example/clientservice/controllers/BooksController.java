package com.example.clientservice.controllers;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class BooksController {


    private  BooksService booksService;
    @LoadBalanced
    private RestTemplate loadBalancedRest;
    private  Environment env;
    private static final Logger LOG = Logger.getLogger(BooksController.class.getName());


    public BooksController(BooksService booksService, Environment env, RestTemplate loadBalancedRest) {
        this.booksService = booksService;
        this.loadBalancedRest = loadBalancedRest;
        this.env = env;
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

    @RequestMapping("/getInfoByRemote")
    public String getInfoFromBookService(){
        String result = this.loadBalancedRest.getForObject("http://book-service", String.class);
        return result;
    }



}
