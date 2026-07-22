package com.springboot.librarymanagementproject.mapper;

import com.springboot.librarymanagementproject.dto.request.BookCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookResponse;
import com.springboot.librarymanagementproject.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse mapToResponse(Book book);
    Book mapToEntity(BookCreateRequest request);
    List<BookResponse> mapToResponseList(List<Book> books);
}
