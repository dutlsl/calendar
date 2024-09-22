package com.bookingcalendar.services;

import com.bookingcalendar.models.Reservation;
import com.bookingcalendar.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public void addReservation(String title, String start, String endTime) {  // 'end'를 'endTime'으로 수정
        Reservation reservation = new Reservation();
        reservation.setTitle(title);

        // 문자열을 LocalDateTime으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        reservation.setStart(LocalDateTime.parse(start, formatter));
        reservation.setEndTime(LocalDateTime.parse(endTime, formatter));  // 'end'를 'endTime'으로 수정

        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
