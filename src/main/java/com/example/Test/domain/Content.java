package com.example.Test.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table(name = "contents")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    @Id
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "user_id")
    Long userId;
}