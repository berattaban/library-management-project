package com.springboot.librarymanagementproject.mapper;

import com.springboot.librarymanagementproject.dto.request.BookingCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookingResponse;
import com.springboot.librarymanagementproject.entity.Booking;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingResponse mapToResponse(Booking booking);
    Booking mapToEntity(BookingCreateRequest request);
    List<BookingResponse> mapToResponseList(List<Booking> bookings);
}
