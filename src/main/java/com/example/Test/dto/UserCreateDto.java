package com.example.Test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class UserCreateDto {
    String name;
    String phoneNumber;
    int age;
}
