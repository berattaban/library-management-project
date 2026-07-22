package com.springboot.librarymanagementproject.dto.request;

import com.springboot.librarymanagementproject.entity.Book;
import com.springboot.librarymanagementproject.entity.User;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingCreateRequest {

    private Long userId;
    private Long bookId;
    private LocalDate bookingDate;
    private LocalDate dueDate;
}
