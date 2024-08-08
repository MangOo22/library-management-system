# Library Management System

## Project Description

This project is a Library Management System API built using Spring Boot. It allows librarians to manage books, patrons, and borrowing records efficiently. The system provides RESTful API endpoints for CRUD operations on books and patrons, as well as functionalities to handle borrowing and returning of books.

## Requirements

### Entities

- **Book**: Represents a book in the library with attributes such as ID, title, author, publication year, ISBN, etc.
- **Patron**: Represents a library patron with details like ID, name, contact information, etc.
- **Borrowing Record**: Tracks the association between books and patrons, including borrowing and return dates.

### API Endpoints

#### Book Management Endpoints

- **GET /api/books**: Retrieve a list of all books.
- **GET /api/books/{id}**: Retrieve details of a specific book by ID.
- **POST /api/books**: Add a new book to the library.
- **PUT /api/books/{id}**: Update an existing book's information.
- **DELETE /api/books/{id}**: Remove a book from the library.

#### Patron Management Endpoints

- **GET /api/patrons**: Retrieve a list of all patrons.
- **GET /api/patrons/{id}**: Retrieve details of a specific patron by ID.
- **POST /api/patrons**: Add a new patron to the system.
- **PUT /api/patrons/{id}**: Update an existing patron's information.
- **DELETE /api/patrons/{id}**: Remove a patron from the system.

#### Borrowing Endpoints

- **POST /api/borrow/{bookId}/patron/{patronId}**: Allow a patron to borrow a book.
- **PUT /api/return/{bookId}/patron/{patronId}**: Record the return of a borrowed book by a patron.

## Data Storage

- Use a database such as H2, MySQL, or PostgreSQL to persist book, patron, and borrowing record details.
- Set up appropriate relationships between entities (e.g., one-to-many between books and borrowing records).

## Validation and Error Handling

- Implement input validation for API requests (e.g., validating required fields, data formats).
- Handle exceptions gracefully and return appropriate HTTP status codes and error messages.

## Security (Optional)

- Implement basic authentication or JWT-based authorization to protect the API endpoints.

## Aspects (Optional)

- Use Aspect-Oriented Programming (AOP) to log method calls, exceptions, and performance metrics for operations like book additions, updates, and patron transactions.

## Caching (Optional)

- Utilize Spring's caching mechanisms to cache frequently accessed data, such as book details or patron information, to improve system performance.

## Transaction Management

- Implement declarative transaction management using Spring's `@Transactional` annotation to ensure data integrity during critical operations.

## Testing

- Write unit tests to validate the functionality of API endpoints.
- Use testing frameworks like JUnit, Mockito, or SpringBootTest for testing.

## Documentation

- Provide clear documentation on how to run the application, interact with API endpoints, and use any authentication if implemented.

## Evaluation Criteria

- **Functionality**: Ensure that CRUD operations for books, patrons, and borrowing records work correctly.
- **Code Quality**: Evaluate the code for readability, maintainability, and adherence to best practices.
- **Error Handling**: Check for proper handling of edge cases and validation errors.
- **Testing**: Assess the coverage and effectiveness of unit tests.
- **Bonus**: Consider additional features like authorization, effective usage of transactions, caching, and aspects.

## Getting Started

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/library-management-system.git
   cd library-management-system
2. **Set Up the Environment**

   Ensure you have Java (JDK 11 or higher) and Maven installed. Configure the application properties as needed in the `src/main/resources/application.properties` file.

3. **Install Dependencies**

   Navigate to the project directory and run:

   ```bash
   ./mvnw install

4. **Run the Application**

   Start the application using:

   ```bash
   ./mvnw spring-boot:run
   ```
   By default, the application will run on http://localhost:8080.

5. **Testing**
    
    Run unit tests using:
    ```bash 
       ./mvnw test
      ```

    Ensure all tests pass to validate the functionality of API endpoints and application logic.

