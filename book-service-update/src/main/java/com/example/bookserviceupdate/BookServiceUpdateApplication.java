package com.example.bookserviceupdate;

import com.example.bookserviceupdate.util.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableEurekaClient
@EnableMongoRepositories
public class BookServiceUpdateApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceUpdateApplication.class, args);
    }


    @Bean
    public ApplicationRunner applicationStartupRunner() {
        return new ApplicationRunner();
    }
}
