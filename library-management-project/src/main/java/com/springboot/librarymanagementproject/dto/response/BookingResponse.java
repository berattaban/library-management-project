package com.springboot.librarymanagementproject.dto.response;

import com.springboot.librarymanagementproject.entity.Book;
import com.springboot.librarymanagementproject.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

    private UUID id;
    private String status;
    private String message;

    private Long userId;
    private String userName;

    private Long bookId;
    private String bookTitle;
    private String author;

    private LocalDate bookingDate;
    private LocalDate dueDate;
}
