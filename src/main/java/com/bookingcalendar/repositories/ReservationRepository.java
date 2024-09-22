package com.bookingcalendar.repositories;

import com.bookingcalendar.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // 기본적인 CRUD는 JpaRepository가 제공
}
