package com.springboot.librarymanagementproject.service;

import com.springboot.librarymanagementproject.dto.request.BookingCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookingResponse;

import java.util.List;
import java.util.UUID;

public interface IBookingService {

    BookingResponse createBooking(BookingCreateRequest request);
    BookingResponse getBookingById(UUID id);
    List<BookingResponse> getAllBookings();
    void deleteBooking(UUID id);


}
