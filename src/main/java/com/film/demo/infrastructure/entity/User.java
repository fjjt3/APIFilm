package com.film.demo.infrastructure.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

@Data
@Table("users")
public class User {
    @Id
    private Long id; // id del post (de la API)
    private Long userId; // userId de la API
    private String title; // title de la API
    private String body; // body de la API
}