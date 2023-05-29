package com.example.Test.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class UserUpdateDto {
    Long id;
    @NonNull
    String name;
    String phoneNumber;
    int age;
}
