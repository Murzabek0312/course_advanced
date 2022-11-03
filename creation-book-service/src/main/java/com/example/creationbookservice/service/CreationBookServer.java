package com.example.creationbookservice.service;

import com.example.creationbookservice.models.Book;
import com.example.creationbookservice.util.BookGenerator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@EnableBinding(Source.class)
@EnableScheduling
@Component
@AllArgsConstructor
public class CreationBookServer {
    private final Source source;
    private final BookGenerator generator;

    @Scheduled(fixedRate = 10000)
    private void sendMessage(){
        Book newBook = generator.createNewBook();
        source.output().send(MessageBuilder.withPayload(newBook).build());
    }
}
