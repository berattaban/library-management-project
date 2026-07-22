# 📚 Library Management System API

This project is a modern **Library Management System** backend application developed using **Java 17** and **Spring Boot 4**, designed with clean architecture principles to manage books, authors, categories, and borrowing processes efficiently.

The system provides fully documented RESTful APIs, type-safe entity-DTO mappings, robust input validation, and PostgreSQL integration for high-performance data operations.

---

## 🏗️ System & Core Architecture

The application is built on the **Separation of Concerns** principle and structured into clean, maintainable layers:

* **Controller Layer:** Exposes RESTful endpoints, handles HTTP requests, and enforces validation rules.
* **Service Layer:** Contains business logic, transactional operations, and domain rules.
* **Repository Layer:** Abstracted data access using Spring Data JPA for seamless database interactions.
* **Mapper Layer:** High-performance, compile-time DTO to Entity mapping powered by MapStruct.

---

## 🚀 Key Technical Features

* **Spring Boot 4 Core:** Leverages the latest features and performance optimizations of Spring Boot 4 and Java 17.
* **MapStruct Object Mapping:** Eliminates boilerplate conversion code using compile-time generated mappers for optimal execution speed.
* **OpenAPI & Swagger Documentation:** Auto-generated, interactive API documentation for fast testing and frontend integration.
* **Robust Validation:** Request payloads are strictly validated using Spring Boot Starter Validation (`@NotNull`, `@Valid`, `@NotBlank`).
* **Lombok Integration:** Reduces repetitive Java boilerplate (getters, setters, constructors) across models and DTOs.
* **Relational Persistence:** Clean database schemas managed by Hibernate and Spring Data JPA with PostgreSQL.

---

## 🛠️ Tech Stack

* **Language:** Java 17
* **Core Framework:** Spring Boot 4
* **Database:** PostgreSQL
* **ORM / Data Access:** Spring Data JPA / Hibernate
* **DTO Mapping:** MapStruct
* **API Documentation:** Springdoc OpenAPI UI
* **Utilities:** Project Lombok
* **Build Tool:** Maven

---

## 📁 Project Structure

```text
library-management-project
 ├── src/main/java/com/springboot/librarymanagementproject
 │    ├── controller      # REST Controllers (Endpoints)
 │    ├── service         # Business Logic Interfaces & Implementations
 │    ├── repository      # Spring Data JPA Interfaces
 │    ├── entity          # Database Models / JPA Entities
 │    ├── dto             # Data Transfer Objects
 │    └── mapper          # MapStruct Interfaces
 └── src/main/resources
      └── application.yml # Database & App Configurations
