package com.example.Test.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    Long id;
    @Column(name = "name")
    String name;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "age")
    int age;
}
