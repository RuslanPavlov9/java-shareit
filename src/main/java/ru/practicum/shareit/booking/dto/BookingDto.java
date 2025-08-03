package ru.practicum.shareit.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.practicum.shareit.booking.model.BookingStatus;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class BookingDto {

    private int id;

    private Timestamp start;

    private Timestamp end;

    private int itemId;

    private int bookerId;

    private BookingStatus status;

}
