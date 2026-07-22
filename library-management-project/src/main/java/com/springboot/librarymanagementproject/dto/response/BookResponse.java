package com.springboot.librarymanagementproject.dto.response;

import com.springboot.librarymanagementproject.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookResponse {

    private Long id;
    private String title;
    private String isbn;
    private String author;
    private String publisher;
    private String description;
    private Integer quantity;
    private Category category;
}
