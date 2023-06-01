package com.example.Test.dto.request;

import com.example.Test.enums.ReactionType;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
public class ReactionRequest {
    @NotNull(message = "reaction type is required")
    ReactionType reactionType;
    @NotNull(message = "field is required")
    Long toUserId;
    @NotNull(message = "field is required")
    Long fromUserId;
}
