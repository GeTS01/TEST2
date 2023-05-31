package com.example.Test.domain;

import com.example.Test.enums.ReactionType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table(name = "reaction")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reaction {
    @Id
    Long id;
    @Column(name = "reaction_type")
    ReactionType reactionType;
    @Column(name = "to_user_id")
    Long toUserId;
    @Column(name = "from_user_id")
    Long FromUserId;
}
