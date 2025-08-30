package ru.practicum.shareit.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practicum.shareit.booking.model.Booking;
import ru.practicum.shareit.booking.model.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    Booking getBookingById(Integer id);

    List<Booking> findAllByBookerIdOrderByStartDesc(Integer bookerId);

    List<Booking> findAllByBookerIdAndStatusOrderByStartDesc(Integer bookerId, BookingStatus status);

    List<Booking> findAllByBookerIdAndEndBeforeOrderByStartDesc(Integer bookerId, LocalDateTime now);

    List<Booking> findAllByBookerIdAndStartAfterOrderByStartDesc(Integer bookerId, LocalDateTime now);

    List<Booking> findAllByBookerIdAndStartBeforeAndEndAfterOrderByIdAsc(
            Integer bookerId,
            LocalDateTime now,
            LocalDateTime alsoNow
    );

    List<Booking> findAllByItemOwnerIdOrderByStartDesc(Integer ownerId);

    List<Booking> findAllByItemOwnerIdAndStatusOrderByStartDesc(Integer bookerId, BookingStatus status);

    List<Booking> findAllByItemOwnerIdAndEndBeforeOrderByStartDesc(Integer bookerId, LocalDateTime now);

    List<Booking> findAllByItemOwnerIdAndStartAfterOrderByStartDesc(Integer bookerId, LocalDateTime now);

    List<Booking> findAllByItemOwnerIdAndStartBeforeAndEndAfterOrderByStartDesc(
            Integer bookerId,
            LocalDateTime now,
            LocalDateTime alsoNow
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

}
