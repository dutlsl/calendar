package com.bookingcalendar.repositories;

import com.bookingcalendar.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // 추가적인 쿼리 메서드가 필요한 경우 여기에 작성합니다.
}
