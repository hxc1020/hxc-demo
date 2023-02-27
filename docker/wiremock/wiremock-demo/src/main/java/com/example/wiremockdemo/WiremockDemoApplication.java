package com.example.wiremockdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.List;

@SpringBootApplication
@RestController
public class WiremockDemoApplication {

    @Autowired
    WebClient webClient;

    @GetMapping("/mock")
    public Mono<MockData> mock() {
        return webClient.get()
                .uri("/mock/data")
                .retrieve()
                .bodyToMono(MockData.class);
    }

    @GetMapping("/")
    public String hello() {
        return "hello world!";
    }

    record MockData(String name, List<User> users) {
    }

    record User(String name, Integer age) {

    }

    public static void main(String[] args) {
        SpringApplication.run(WiremockDemoApplication.class, args);
    }

}
