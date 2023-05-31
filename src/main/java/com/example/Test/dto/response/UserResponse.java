package com.example.Test.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserResponse {
    Long id;
    String name;
    String phoneNumber;
    int age;

}