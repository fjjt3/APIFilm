package com.film.demo.domain;

import com.film.demo.infrastructure.entity.Film;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service // Marca la clase como un servicio de Spring
public class FilmService {

    private final WebClient webClient;

    public FilmService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public Mono<Film> getFilmInfo(String filmId) {
        String apiUrl = "https://api.filmaffinity.com/v1/films/" + filmId;

        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(Film.class);
    }
}

