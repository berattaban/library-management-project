package com.springboot.librarymanagementproject.dto.request;

import com.springboot.librarymanagementproject.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class BookCreateRequest {

    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private String description;
    private Integer quantity;
    private Category category;
}
