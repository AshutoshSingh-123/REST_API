# Employee Management REST API

This is a RESTful API built with Spring Boot for managing employees. It supports basic CRUD (Create, Read, Update, Delete) operations.

## Features

- Create a new employee
- Retrieve an existing employee
- Update an existing employee
- Delete an employee
- Retrieve all employees

## Technologies Used

- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL Database

## Setup and Installation

1. Clone the repository: `git clone https://github.com/AshutoshSingh-123/REST_API.git`
2. Navigate to the project directory: `cd REST_API`
3. Build the project: `./mvnw clean install`
4. Run the application: `./mvnw spring-boot:run`

## API Endpoints

- `POST /api/employees`: Create a new employee
- `GET /api/employees/{id}`: Retrieve an employee by ID
- `PUT /api/employees`: Update an employee
- `DELETE /api/employees/{id}`: Delete an employee by ID
- `GET /api/employees`: Retrieve all employees


