package com.example.Test.service.impl;

import com.example.Test.domain.User;
import com.example.Test.dto.UserCreateDto;
import com.example.Test.dto.UserUpdateDto;
import com.example.Test.repository.UserRepository;
import com.example.Test.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    @Transactional
    public User create(UserCreateDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .phoneNumber(userDto.getPhoneNumber())
                .age(userDto.getAge())
                .build();
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public Optional<User> updateById(UserUpdateDto userUpdateDto) {
        Optional<User> optionalUser = userRepository.findById(userUpdateDto.getId());
        if (optionalUser.isEmpty()) {
            log.error("User not found");
            return Optional.empty();
            //todo как правильно оформляьть исклюсения
        }
        var user = optionalUser.get();
        user.setId(userUpdateDto.getId());
        user.setName(userUpdateDto.getName());
        user.setAge(userUpdateDto.getAge());
        user.setPhoneNumber(userUpdateDto.getPhoneNumber());
        userRepository.update(user);
        return Optional.of(user);
    }

    @Override
    public List<User> getUserByIds(Set<Long> ids) {
        return userRepository.findByLongIds(ids)
                .stream()
                .toList();
    }
}