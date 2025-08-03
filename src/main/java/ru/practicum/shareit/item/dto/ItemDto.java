package ru.practicum.shareit.item.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
public class ItemDto {

    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private Boolean available;

}
