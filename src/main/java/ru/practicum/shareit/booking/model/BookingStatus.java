package ru.practicum.shareit.booking.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BookingStatus {

    WAITING("WAITING"),

    APPROVED("APPROVED"),

    REJECTED("REJECTED"),

    CANCELED("CANCELED");

    private final String value;

}
