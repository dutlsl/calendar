package com.bookingcalendar.controller;

import com.bookingcalendar.models.Reservation;
import com.bookingcalendar.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public String viewCalendar(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservationsJson", reservations);

        // 예약 데이터 로그 출력
        System.out.println("Reservations: " + reservations);

        return "calendar"; // calendar.html 템플릿 파일 반환
    }

    @PostMapping("/add-reservation")
    @ResponseBody
    public String addReservation(@RequestParam("title") String title,
                                 @RequestParam("start") String start,
                                 @RequestParam("endTime") String endTime) {
        reservationService.addReservation(title, start, endTime);
        return "success"; // 성공 메시지 반환
    }

    @PostMapping("/delete-reservation")
    @ResponseBody
    public String deleteReservation(@RequestParam("id") Long id) {
        try {
            reservationService.deleteReservation(id);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
