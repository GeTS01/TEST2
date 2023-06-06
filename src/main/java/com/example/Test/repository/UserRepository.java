package com.example.Test.repository;

import com.example.Test.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository {
    void save(User user);
    void update(User user);
    Optional<User> findById(Long id);
    List<User> findByLongIds(Set<Long> ids);
    void delete(Long id);
    boolean exist(String phoneNumber);
    List<User> getListUser ();

}