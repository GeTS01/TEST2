package com.example.Test.service.impl;

import com.example.Test.domain.User;
import com.example.Test.dto.request.UserRequest;
import com.example.Test.dto.UserUpdateDto;
import com.example.Test.dto.response.UserResponse;
import com.example.Test.repository.UserRepository;
import com.example.Test.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    @Transactional
    public void create(UserRequest userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .phoneNumber(userDto.getPhoneNumber())
                .age(userDto.getAge())
                .build();
        String userPhoneNumber = user.getPhoneNumber();
//        boolean check = userRepository.exist(userPhoneNumber);
//        if (!check) {
//        }
        userRepository.save(user);
    }

    @Override
    public Optional<UserResponse> getById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        var item = userRepository.findById(id).get();
        return Optional.of(new UserResponse(item.getId(), item.getName(), item.getPhoneNumber(), item.getAge()));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<User> check = userRepository.findById(id);
        if (check.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public Optional<UserResponse> updateById(UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(userUpdateDto.getId());
            if (optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND); //todo как правильно оформляьть исключения
        }
        User user = optionalUser.get();
        user.setId(userUpdateDto.getId());
        user.setName(userUpdateDto.getName());
        user.setAge(userUpdateDto.getAge());
        user.setPhoneNumber(userUpdateDto.getPhoneNumber());
        userRepository.update(user);
        return Optional.of(new UserResponse(user.getId(), user.getName(), user.getPhoneNumber(), user.getAge()));
    }

    @Override
    public List<User> userList() {
        return userRepository.getListUser();
    }
}