package com.example.Test.service;

import com.example.Test.dto.UserUpdateDto;
import com.example.Test.dto.request.UserRequest;
import com.example.Test.dto.response.UserResponse;

import java.util.Optional;

public interface UserService {
    void create (UserRequest userDto);
    Optional<UserResponse> getById(Long id);
    void deleteById(Long id);
    Optional<UserResponse> updateById(UserUpdateDto userUpdateDto);
}