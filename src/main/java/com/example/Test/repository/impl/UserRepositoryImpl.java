package com.example.Test.repository.impl;

import com.example.Test.domain.User;
import com.example.Test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Repository
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT = """
            insert into users
            (
            name, phone_number, age
            )
            values
            (
            :name, :phoneNumber, :age
            )
            """;

    private static final String UPDATE = """   
            update users set
            name = :name,
            phone_number = :phoneNumber,
            age = :age
            where id = :id
            """;

    private static final String FIND_BY_ID = """
            select * from users
            where id = :id
            """;

    private static final String FIND_BY_IDS = """
            select * from users u
            where u.id = any(array[:ids])
            """;

    private static final String DELETE_BY_ID = """
            delete from users
            where id = :id
            """;

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public void save(User user) {
        int rowsAffected = namedParameterJdbcTemplate.update(INSERT, toParameterSource(user));
        if (rowsAffected != 1) {
            throw new IllegalStateException("Failed to save suggestionBpmTone with id " + user.getId());
        }
    }

    @Override
    public void update(User user) {
        int rowsAffected = namedParameterJdbcTemplate.update(UPDATE, toParameterSource(user));
        if (rowsAffected != 1) {
            throw new IllegalStateException("Failed to save suggestionBpmTone with id " + user.getId());
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return namedParameterJdbcTemplate.query(FIND_BY_ID, Map.of("id", id),
                        new BeanPropertyRowMapper<>(User.class))
                .stream()
                .findFirst();
    }

    @Override
    public List<User> findByLongIds(Set<Long> ids) {
        return namedParameterJdbcTemplate.query(FIND_BY_IDS, Map.of("ids", ids),
                new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void delete(Long id) {
        namedParameterJdbcTemplate.update(DELETE_BY_ID, Map.of("id", id));
    }

    private MapSqlParameterSource toParameterSource(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", user.getId());
        params.addValue("name", user.getName());
        params.addValue("phoneNumber", user.getPhoneNumber());
        params.addValue("age", user.getAge());
        return params;
    }
}