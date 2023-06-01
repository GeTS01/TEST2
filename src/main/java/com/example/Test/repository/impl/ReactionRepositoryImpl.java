package com.example.Test.repository.impl;

import com.example.Test.domain.Reaction;
import com.example.Test.repository.ReactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

import static com.example.Test.utils.EnumHelper.getEnumName;
import static lombok.AccessLevel.PRIVATE;

@Repository
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ReactionRepositoryImpl implements ReactionRepository {


    private static final String CREATE_REACTION = """
            insert into reaction
            (
            reaction_type, to_user_id, from_user_id
            )
            values
            (
            :reactionType, :toUserId, :fromUserId
            )
            """;
    private static final String DELETE_BY_ID = """
            delete from reaction
            where id = :id
            """;

    private static final String FIND_BY_ID = """
            select * from reaction
            where id = :id
            """;


    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void save(Reaction reaction) {
        namedParameterJdbcTemplate.update(CREATE_REACTION, toParameterSource(reaction));
    }

    @Override
    public void deleteById(Long id) {
        namedParameterJdbcTemplate.update(DELETE_BY_ID, Map.of("id", id));
    }

    @Override
    public Optional<Reaction> findById(Long id) {
        return namedParameterJdbcTemplate.query(FIND_BY_ID, Map.of("id", id),
                new BeanPropertyRowMapper<>(Reaction.class))
                .stream()
                .findFirst();
    }

    private MapSqlParameterSource toParameterSource(Reaction reaction) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", reaction.getId());
        params.addValue("reactionType", getEnumName(reaction.getReactionType()));
        params.addValue("toUserId", reaction.getToUserId());
        params.addValue("fromUserId", reaction.getFromUserId());
        return params;
    }
}
