package com.bookingcalendar.controller;

import com.bookingcalendar.models.Reservation;
import com.bookingcalendar.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/")
    public String viewCalendar(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "calendar"; // calendar.html 템플릿 파일을 찾음
    }

    @PostMapping("/add-reservation")
    public String addReservation(@RequestParam("title") String title,
                                 @RequestParam("start") String start,
                                 @RequestParam("endTime") String endTime) {
        reservationService.addReservation(title, start, endTime);
        return "redirect:/"; // 예약 후 메인 페이지로 리다이렉트
    }


    @PostMapping("/delete-reservation")
    public String deleteReservation(@RequestParam("id") Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/";
    }
}
