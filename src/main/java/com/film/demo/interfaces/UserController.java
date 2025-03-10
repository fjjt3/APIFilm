package com.film.demo.interfaces;

import com.film.demo.domain.UserService;
import com.film.demo.infrastructure.UserRepository;
import com.film.demo.infrastructure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{userId}")
    public Mono<User> getUser(@PathVariable Long userId) {
        return userService.getUserInfo(userId)
                .flatMap(user -> userRepository.save(user)); // Guarda el usuario en la base de datos
    }
}