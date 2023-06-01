package com.example.Test.repository;

import com.example.Test.domain.Reaction;
import com.example.Test.domain.User;

import java.util.Optional;

public interface ReactionRepository {
    void save(Reaction reaction);
    void deleteById(Long id);
    Optional<Reaction> findById(Long id);
}
