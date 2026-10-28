package com.spandan.tabletrail.reservation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReservationRepository extends JpaRepository<RestaurantReservation,Long> {}
