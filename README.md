# Employee Management System API

This is a Java Spring Boot project for an Employee Management System API. 
It provides endpoints for managing employees, such as creating, retrieving, updating, and deleting employee records.

## Technologies Used

- Java 17
- Spring Boot 3.0.5
- MySQL Database
- Maven

## Getting Started

To get started with the project, you can clone the repository and run it locally.
This will start the application on `http://localhost:8081`.

## API Endpoints

The following API endpoints are available:

- `GET /employees`: Retrieve a list of all employees
- `GET /employees/{id}`: Retrieve an employee by ID
- `POST /employees`: Create a new employee
- `PUT /employees/{id}`: Update an existing employee by ID
- `DELETE /employees/{id}`: Delete an employee by ID
- `GET /employees/surname/{surname}`: Retrieve an employee by Surname
- `GET /employees/salary/{salary}`: Retrieve a list of all employees whos salary is less then {salary}

## Unit Testing

The project includes unit tests for the service layer using JUnit 5 and Mockito.
