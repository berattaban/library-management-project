package com.springboot.librarymanagementproject.service.impl;

import com.springboot.librarymanagementproject.dto.request.BookCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookResponse;
import com.springboot.librarymanagementproject.entity.Book;
import com.springboot.librarymanagementproject.mapper.BookMapper;
import com.springboot.librarymanagementproject.repository.BookRepository;
import com.springboot.librarymanagementproject.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    public BookResponse createBook(BookCreateRequest request) {
        Book book = Book.builder()
                .title(request.getTitle())
                .isbn(request.getIsbn())
                .author(request.getAuthor())
                .title(request.getTitle())
                .publisher(request.getPublisher())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .category(request.getCategory())
                .build();

        Book savedBook = bookRepository.save(book);

        return BookResponse.builder()
                .id(savedBook.getId())
                .title(savedBook.getTitle())
                .isbn(savedBook.getIsbn())
                .author(savedBook.getAuthor())
                .title(savedBook.getTitle())
                .publisher(savedBook.getPublisher())
                .description(savedBook.getDescription())
                .quantity(savedBook.getQuantity())
                .category(savedBook.getCategory())
                .build();
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookMapper.mapToResponseList(bookRepository.findAll());
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
