package com.example.Test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class UserCreateDto {
    @NotNull
    String name;
    String phoneNumber;
    int age;
}
