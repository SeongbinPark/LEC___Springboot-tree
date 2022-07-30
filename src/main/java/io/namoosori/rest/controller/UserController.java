package io.namoosori.rest.controller;

import io.namoosori.rest.entity.User;
import io.namoosori.rest.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public String register(@RequestBody User newUser) {
        return userService.register(newUser);
    }

    @GetMapping("/{id}")
    public User find(@PathVariable String id) {
        return userService.find(id);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @PutMapping
    public void modify(@RequestBody User newUser) {
        userService.modify(newUser);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable String id) {
        userService.remote(id);
    }


}
