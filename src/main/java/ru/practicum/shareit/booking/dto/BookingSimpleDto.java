package ru.practicum.shareit.booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.booking.model.BookingStatus;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BookingSimpleDto {

    private int id;

    private LocalDateTime start;

    private LocalDateTime end;

    private int itemId;

    private int bookerId;

    private BookingStatus status;

}
