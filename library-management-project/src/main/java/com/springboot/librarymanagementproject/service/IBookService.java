package com.springboot.librarymanagementproject.service;

import com.springboot.librarymanagementproject.dto.request.BookCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookResponse;

import java.util.List;

public interface IBookService {

    BookResponse createBook(BookCreateRequest request);
    List<BookResponse> getAllBooks();
    void deleteBookById(Long id);
}
