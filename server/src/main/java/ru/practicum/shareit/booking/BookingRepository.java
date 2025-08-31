package ru.practicum.shareit.booking;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.booking.model.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Booking getBookingById(Integer id);

    List<Booking> findAllByBookerId(Integer bookerId, Pageable page);

    List<Booking> findAllByBookerIdAndStatus(Integer bookerId, BookingStatus status, Pageable page);

    List<Booking> findAllByBookerIdAndEndBefore(Integer bookerId, LocalDateTime now, Pageable page);

    List<Booking> findAllByBookerIdAndStartAfter(Integer bookerId, LocalDateTime now, Pageable page);

    List<Booking> findAllByBookerIdAndStartBeforeAndEndAfter(
            Integer bookerId,
            LocalDateTime now,
            LocalDateTime alsoNow,
            Pageable page
    );

    Optional<Booking> findFirstByItemIdAndStatusAndStartBeforeOrderByStartDesc(
            Integer itemId,
            BookingStatus status,
            LocalDateTime now
    );

    Optional<Booking> findFirstByItemIdAndStatusAndStartAfterOrderByStartAsc(
            Integer itemId,
            BookingStatus status,
            LocalDateTime now
    );

    Optional<Booking> findFirstByBookerIdAndItemIdAndStatusEqualsAndEndIsBefore(
            Integer bookerId,
            Integer itemId,
            BookingStatus status,
            LocalDateTime now
    );

    List<Booking> findAllByItemOwnerIdAndStatus(Integer bookerId, BookingStatus status, Pageable page);

    List<Booking> findAllByItemOwnerIdAndEndBefore(Integer bookerId, LocalDateTime now, Pageable page);

    List<Booking> findAllByItemOwnerIdAndStartAfter(Integer bookerId, LocalDateTime now, Pageable page);

    List<Booking> findAllByItemOwnerId(Integer ownerId, Pageable page);

    List<Booking> findAllByItemOwnerIdAndStartBeforeAndEndAfter(
            Integer bookerId,
            LocalDateTime now,
            LocalDateTime alsoNow,
            Pageable page
    );

}
