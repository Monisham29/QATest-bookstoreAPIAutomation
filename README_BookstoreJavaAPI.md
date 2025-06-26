# BookstoreJavaAPI

## Overview

This project is a Java-based automation framework that mimics and tests a Bookstore API originally built with FastAPI. It includes:

- REST API test automation using **RESTAssured**
- Token-based login and CRUD operations
- JSON data-driven input
- TestNG for test management
- Maven for dependency management
- Jenkins for CI/CD

## Technologies

- Java 11+
- Maven
- RESTAssured
- TestNG
- Jenkins (YAML pipeline)

## API Endpoints Tested

- `POST /signup`: Create new user
- `POST /login`: Login to get access token
- `GET /health`: Health check
- `POST /books/`: Create a book
- `PUT /books/{book_id}`: Update a book
- `DELETE /books/{book_id}`: Delete a book by ID
- `GET /books/{book_id}`: Retrieve a single book by ID
- `GET /books/`: Get a list of all books


## Getting Started

### 1. Install Dependencies

```bash
mvn clean install
```

### 2. Run Tests

```bash
mvn test
```

### 3. Run Main Method

```bash
mvn exec:java -Dexec.mainClass="bookstore.MainRunner"
```

## Folder Structure

```
src/main/java/       # Core API classes and models
src/test/java/       # TestNG test suite
data/                # Test input JSON
jenkins.yml          # Jenkins pipeline
pom.xml              # Maven dependencies
```
