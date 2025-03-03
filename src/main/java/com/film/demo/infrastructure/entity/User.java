package com.film.demo.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("users") // Cambia el nombre de la tabla a "users"
public class User {
    @Id
    private Long id; // userId de la API
    private String title; // title de la API
    private String body; // body de la API
}