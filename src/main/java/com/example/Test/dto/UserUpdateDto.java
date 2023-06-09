package com.example.Test.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserUpdateDto {
    Long id;
    @NotNull(message = "name must not be empty")
    @Size(min = 3, max = 20, message = "character limit")
    @NotNull(message = "Поле с именем не должно быть пустым")
    String name;
    @NotNull(message = "phone number must not be empty")
    String phoneNumber;
    int age;
}
