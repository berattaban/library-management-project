package com.springboot.librarymanagementproject.controller;

import com.springboot.librarymanagementproject.dto.request.BookCreateRequest;
import com.springboot.librarymanagementproject.dto.response.BookResponse;
import com.springboot.librarymanagementproject.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/books")
@RequiredArgsConstructor
public class BookController {

    private final IBookService bookService;

    @PostMapping("/create")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookCreateRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.status(HttpStatus.OK).body("The book deleted successfully!");
    }
}
