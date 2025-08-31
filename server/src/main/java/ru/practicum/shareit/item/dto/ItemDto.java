package ru.practicum.shareit.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@NoArgsConstructor
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class ItemDto {

    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private Boolean available;

    private Integer requestId;

}
