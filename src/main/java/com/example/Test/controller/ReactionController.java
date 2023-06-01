package com.example.Test.controller;

import com.example.Test.dto.request.ReactionRequest;
import com.example.Test.service.ReactionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("reaction")
public class ReactionController {
    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping
    public void create(@RequestBody @Valid ReactionRequest reactionRequest) {
        reactionService.create(reactionRequest);
    }

    @DeleteMapping
    public void deleteById(Long id){
        reactionService.delete(id);
    }
}
