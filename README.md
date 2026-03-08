# Vehicle Management Backend API

A Spring Boot REST API for managing vehicle fleets. This project demonstrates a complete backend architecture from database design to API endpoint implementation.

## 🚀 Technologies Used
- **Java** (Latest version features)
- **Spring Boot** (REST, Data JPA)
- **MySQL** (Relational Database)
- **Hibernate** (ORM)
- **Maven** (Dependency Management)

## 🛠️ Key Features
- **Full CRUD Operations:** Manage vehicle inventory efficiently.
- **Robust Validation:** Implemented server-side validation for data integrity (e.g., license plate formats, mileage constraints).
- **Clean Architecture:** Utilizes DTOs and Mappers to decouple the API layer from the persistence layer.
- **Global Error Handling:** Consistent API responses using Spring Exception Handling.

## ⚙️ How to Run
1. Clone the repository.
2. Configure your MySQL settings in `src/main/resources/application.properties`.
3. Run the application using `./mvnw spring-boot:run`.
4. Access the API at `http://localhost:8080/api/v1/vehicles`.
