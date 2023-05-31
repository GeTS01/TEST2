package com.example.Test.controller;

import com.example.Test.domain.User;
import com.example.Test.dto.request.RequestUser;
import com.example.Test.dto.UserUpdateDto;
import com.example.Test.dto.response.UserResponse;
import com.example.Test.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void create(@RequestBody @Valid RequestUser userDto) {
        userService.create(userDto);
    }

    @GetMapping
    public Optional<UserResponse> getById(Long id) {
        return userService.getById(id);
    }

    @DeleteMapping
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    @PatchMapping
    public Optional<UserResponse> update(@RequestBody @Valid UserUpdateDto userUpdateDto) {
        return userService.updateById(userUpdateDto);
    }
}