package ru.practicum.shareit.item.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.booking.dto.BookingSimpleDto;
import ru.practicum.shareit.comment.dto.CommentDto;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Data
public class ItemExtendedDto {

    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    private Boolean available;

    private BookingSimpleDto lastBooking;

    private BookingSimpleDto nextBooking;

    private List<CommentDto> comments;

}
