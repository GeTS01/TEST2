package com.example.Test.service.impl;

import com.example.Test.domain.Reaction;
import com.example.Test.dto.request.ReactionRequest;
import com.example.Test.repository.ReactionRepository;
import com.example.Test.service.ReactionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReactionServiceImpl implements ReactionService {
    ReactionRepository reactionRepository;

    @Override
    public void create(ReactionRequest reactionRequest) {
        Reaction reaction = Reaction.builder()
                .reactionType(reactionRequest.getReactionType())
                .toUserId(reactionRequest.getToUserId())
                .FromUserId(reactionRequest.getFromUserId())
                .build();
        reactionRepository.save(reaction);
    }

    @Override
    public void delete(Long id) {
        Optional<Reaction> reactionOptional = reactionRepository.findById(id);
        if (reactionOptional.isEmpty()) {
            return;
        }
        reactionRepository.deleteById(id);
    }
}
