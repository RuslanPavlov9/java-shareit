package ru.practicum.shareit.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class UserDto {

    private Integer id;

    @NotNull
    private String name;

    @NotNull
    @Email
    private String email;
}
