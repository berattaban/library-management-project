package com.springboot.librarymanagementproject.controller;

import com.springboot.librarymanagementproject.dto.request.BookingCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookingResponse;
import com.springboot.librarymanagementproject.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final IBookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingResponse> createBooking(BookingCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(request));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.getBookingById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookingResponse>> getAllBookings(){
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.getAllBookings());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable UUID id){
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("The booking deleted successfully!");
    }
}
