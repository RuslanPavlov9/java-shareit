package ru.practicum.shareit.booking.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BookingCreateDto {

    private LocalDateTime start;

    private LocalDateTime end;

    @NonNull
    private Integer itemId;

}
