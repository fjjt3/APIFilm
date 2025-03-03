package com.film.demo.domain;

import com.film.demo.infrastructure.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private final WebClient webClient;

    public UserService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Mono<User> getUserInfo(Long userId) {
        return webClient.get()
                .uri("/posts/{id}", userId) // Endpoint de JSONPlaceholder
                .retrieve()
                .bodyToMono(User.class); // Mapea la respuesta a la entidad User
    }
}