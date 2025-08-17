package ru.practicum.shareit.request.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ItemRequestDto {

    private int id;

    private String description;

    private int requesterId;

    private Timestamp created;

}
