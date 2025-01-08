### Tickets

## Overview
This project is a Spring Boot application designed to manage tickets. It uses Gradle for build automation and MySQL as the database. The application provides a RESTful API for creating, updating, retrieving, and deleting tickets.

## Features
- **Ticket Management**: Create, update, retrieve, and delete tickets.
- **User Authentication**: Secure endpoints with user authentication.
- **Database Integration**: Uses MySQL for persistent storage.
- **Docker Support**: Dockerfile and `docker-compose.yml` for containerization.
- **Environment Configuration**: Uses environment variables for configuration.

## Prerequisites
- Java 17
- Gradle
- Docker
- Docker Compose

## Setup
1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/your-repo.git
    cd your-repo
    ```

2. **Create a `.env` file**:
    ```plaintext
    MYSQL_DATABASE=your_database
    MYSQL_USER=your_user
    MYSQL_PASSWORD=your_password
    MYSQL_ROOT_PASSWORD=your_root_password
    ```

3. **Build and run the application using Docker Compose**:
    ```sh
    docker-compose up --build
    ```

## Usage
- The application will be available at `http://localhost:8080`.
- Use a tool like Postman to interact with the API.

## Endpoints
- `GET /tickets`: Retrieve all tickets.
- `POST /tickets`: Create a new ticket.
- `GET /tickets/{id}`: Retrieve a ticket by ID.
- `PUT /tickets/{id}`: Update a ticket by ID.
- `DELETE /tickets/{id}`: Delete a ticket by ID.

## Documentation
For detailed API documentation, refer to the [API Documentation](docs_api.md).

## Migration Instructions
For database migration instructions, refer to the [Migration Instructions](migration_instructions.md).