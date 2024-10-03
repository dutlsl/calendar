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

    public void addReservation(String title, String start, String endTime) {
        Reservation reservation = new Reservation();
        reservation.setTitle(title);

        // 문자열을 LocalDateTime으로 변환
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime, formatter);

        reservation.setStart(startDateTime);
        reservation.setEndTime(endDateTime);

        reservationRepository.save(reservation);

        // 예약 저장 후 로그 출력
        System.out.println("Reservation saved: " + reservation);
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
