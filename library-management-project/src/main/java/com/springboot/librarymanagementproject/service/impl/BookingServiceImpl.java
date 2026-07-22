package com.springboot.librarymanagementproject.service.impl;

import com.springboot.librarymanagementproject.dto.request.BookingCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookingResponse;
import com.springboot.librarymanagementproject.entity.Book;
import com.springboot.librarymanagementproject.entity.Booking;
import com.springboot.librarymanagementproject.entity.User;
import com.springboot.librarymanagementproject.repository.BookRepository;
import com.springboot.librarymanagementproject.repository.BookingRepository;
import com.springboot.librarymanagementproject.repository.UserRepository;
import com.springboot.librarymanagementproject.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;


    @Override
    public BookingResponse createBooking(BookingCreateRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("The user not found!"));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(()-> new RuntimeException("The book not found!"));

        if (book.getQuantity() <= 0){
            throw new RuntimeException("The book quantity must be greater than 0");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        Booking booking = Booking.builder()
                .user(user)
                .book(book)
                .bookingDate(request.getBookingDate())
                .dueDate(request.getDueDate())
                .build();

        Booking bookingSaved = bookingRepository.save(booking);

        return BookingResponse.builder()
                .id(bookingSaved.getId())
                .status("SUCCESS")
                .message("Book reserved successfully")
                .userId(bookingSaved.getUser().getId())
                .userName(user.getFirstName()+" "+user.getLastName())
                .bookId(bookingSaved.getBook().getId())
                .bookTitle(bookingSaved.getBook().getTitle())
                .author(bookingSaved.getBook().getAuthor())
                .bookingDate(bookingSaved.getBookingDate())
                .dueDate(bookingSaved.getDueDate())
                .build();


    }

    @Override
    public BookingResponse getBookingById(UUID id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The booking not found!"));

        BookingResponse response = new BookingResponse();
        response.setId(booking.getId());
        response.setUserId(booking.getUser().getId());
        response.setBookId(booking.getBook().getId());
        response.setBookingDate(booking.getBookingDate());
        response.setDueDate(booking.getDueDate());
        return response;
    }

    @Override
    public List<BookingResponse> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        List<BookingResponse> responses = new ArrayList<>();

        for (Booking booking : bookings) {

            BookingResponse response = BookingResponse.builder()
                    .id(booking.getId())
                    .status("SUCCESS")
                    .message("Book reserved succesfully")
                    .userId(booking.getUser().getId())
                    .userName(booking.getUser().getFirstName() + " " + booking.getUser().getLastName())
                    .bookId(booking.getBook().getId())
                    .bookTitle(booking.getBook().getTitle())
                    .author(booking.getBook().getAuthor())
                    .bookingDate(booking.getBookingDate())
                    .dueDate(booking.getDueDate())
                    .build();

            responses.add(response);
        }
        return responses;

    }

    @Override
    public void deleteBooking(UUID id) {
        bookingRepository.deleteById(id);
    }
}
