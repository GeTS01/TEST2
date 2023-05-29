package com.example.Test.controller;

import com.example.Test.domain.User;
import com.example.Test.dto.UserCreateDto;
import com.example.Test.dto.UserUpdateDto;
import com.example.Test.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody UserCreateDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping
    public Optional<User> getById(Long id) {
        return userService.getById(id);
    }

    @DeleteMapping
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @PatchMapping
    public Optional<User> update(@RequestBody UserUpdateDto userUpdateDto) {
        return userService.updateById(userUpdateDto);
    }
}