# E-Commerce Order & Delivery Management Platform

A full-stack e-commerce platform designed to demonstrate backend and software engineering concepts.

## Technology Stack

- Java 21
- Spring Boot
- Spring Data JPA
- Spring Security
- MySQL
- React (frontend - planned)
- Redis (caching - planned)
- Docker (containerization - planned)

## Current Backend Features

- Product CRUD REST APIs
- Product search and category filtering
- Pagination
- Request validation
- Global exception handling
- MySQL persistence
- Soft deletion of products
- Transaction management

## Planned Features

- JWT authentication
- Customer and admin roles
- Cart management
- Order processing
- Inventory reservation
- Delivery tracking
- React frontend
- Redis caching
- Docker Compose
- Unit and integration testing
- API documentation

## Running the Backend

1. Create a MySQL database named `ecommerce_platform`.
2. Set `DB_USERNAME` and `DB_PASSWORD` environment variables if required.
3. Run:

```bash
mvn spring-boot:run
```

The API runs on `http://localhost:8080`.
