package com.example.Test.service;

import com.example.Test.dto.request.ReactionRequest;

public interface ReactionService {

    void create(ReactionRequest reactionRequest);
    void delete(Long id);
}
