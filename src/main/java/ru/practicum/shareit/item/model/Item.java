package ru.practicum.shareit.item.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.user.model.User;

@Data
@NoArgsConstructor
public class Item {

    private int id;

    private String name;

    private String description;

    private boolean available;

    private User owner;

}
