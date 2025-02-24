package com.film.demo.infrastructure;

import com.film.demo.infrastructure.entity.Film;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends ReactiveCrudRepository<Film, Long> {
}

