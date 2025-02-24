package com.film.demo.interfaces;

import com.film.demo.domain.FilmService;
import com.film.demo.infrastructure.FilmRepository;
import com.film.demo.infrastructure.entity.Film; // Importa la entidad Film
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*; // Importa las anotaciones necesarias
import reactor.core.publisher.Mono; // Importa Mono

@RestController
@RequestMapping("/api/films")
public class FilmController {

    private final FilmService filmService;
    private final FilmRepository filmRepository;

    @Autowired // Añade @Autowired a los constructores
    public FilmController(FilmService filmService, FilmRepository filmRepository) {
        this.filmService = filmService;
        this.filmRepository = filmRepository;
    }

    @GetMapping("/{filmId}")
    public Mono<Film> getFilm(@PathVariable String filmId) {
        return filmService.getFilmInfo(filmId)
                .flatMap(film -> filmRepository.save(film)); // Corrección
    }


    // Otros métodos del controlador (ejemplo)
   /* @GetMapping
    public Flux<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    @PostMapping
    public Mono<Film> createFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    @DeleteMapping("/{filmId}")
    public Mono<Void> deleteFilm(@PathVariable String filmId) {
        return filmRepository.deleteById(filmId);
    }*/
}

