package com.bookingcalendar.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime start;
    private LocalDateTime endTime;  // 'end'를 'endTime'으로 수정

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEndTime() {
        return endTime;  // 'end'를 'endTime'으로 수정
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;  // 'end'를 'endTime'으로 수정
    }
}
