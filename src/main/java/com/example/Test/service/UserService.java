package com.example.Test.service;

import com.example.Test.domain.User;
import com.example.Test.dto.UserCreateDto;
import com.example.Test.dto.UserUpdateDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    User create (UserCreateDto userDto);

    Optional<User> getById(Long id);

    void deleteById(Long id);

    Optional<User> updateById(UserUpdateDto userUpdateDto);

    List<User> getUserByIds(Set<Long> ids);

}
