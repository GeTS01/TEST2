package com.example.Test.dto.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class RequestUser {
    @NotNull(message = "name must not be empty")
    @Size(min = 3, max = 20, message = "character limit")
    String name;
    @NotNull(message = "phone number must not be empty")
    String phoneNumber;
    int age;
}
