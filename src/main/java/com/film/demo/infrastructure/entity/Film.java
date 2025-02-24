package com.film.demo.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("films") // Especifica el nombre de la tabla en la base de datos
public class Film {
    @Id // Usa la anotación @Id de Spring Data
    private Long id; // No necesitas @GeneratedValue, R2DBC maneja la generación automática
    private String name;
    private int year;
    private String director;
    private String genre;
    private int duration;
}

