package com.spandan.tabletrail.reservation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationControllerTest {

    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationController controller;

    @Test
    void shouldListReservations() {
        when(repository.findAll()).thenReturn(List.of());

        assertTrue(controller.all().isEmpty());
        verify(repository).findAll();
    }

    @Test
    void shouldFindReservationById() {
        RestaurantReservation reservation = createReservation();
        when(repository.findById(1L)).thenReturn(Optional.of(reservation));

        assertEquals("Aarav Patil", controller.one(1L).getCustomerName());
    }

    @Test
    void shouldThrowWhenReservationDoesNotExist() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(
            java.util.NoSuchElementException.class,
            () -> controller.one(99L)
        );
    }

    @Test
    void shouldCreateReservation() {
        RestaurantReservation reservation = createReservation();
        when(repository.save(reservation)).thenReturn(reservation);

        assertEquals(reservation, controller.create(reservation));
        verify(repository).save(reservation);
    }

    private RestaurantReservation createReservation() {
        RestaurantReservation reservation = new RestaurantReservation();
        reservation.setId(1L);
        reservation.setCustomerName("Aarav Patil");
        reservation.setEmail("aarav@example.com");
        reservation.setReservationTime(
            LocalDateTime.of(2026, 12, 15, 19, 30)
        );
        reservation.setPartySize(4);
        reservation.setSpecialRequest("Window seat");
        return reservation;
    }
}
