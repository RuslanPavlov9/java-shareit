package ru.practicum.shareit.request.model;

import jakarta.persistence.*;
import lombok.*;
import ru.practicum.shareit.user.model.User;

import java.time.LocalDateTime;


@Entity
@NoArgsConstructor
@Table(name = "requests", schema = "public")
@Getter
@Setter
@ToString
public class ItemRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id")
    private User requester;

    private LocalDateTime created;

}
