# MVVM Implementation in Spring Boot

## Overview
This project demonstrates the implementation of the **MVVM (Model-View-ViewModel)** architectural pattern in a Spring Boot application. The MVVM architecture separates concerns in a structured manner, ensuring the scalability, maintainability, and testability of the codebase.

---

## MVVM in Spring Boot

### Components:
1. **Model**: Represents the data and business logic layer of the application. It typically includes:
   - Entity classes (e.g., `Employee`)
   - Repository interfaces to interact with the database.

2. **View**: Represents the client side, where the user interacts with the application. This could be a frontend application (e.g., Angular, React) or API consumers (Postman, browser).

3. **ViewModel**: Acts as a bridge between the Controller and the Model. It processes data from the model layer and prepares it for the view layer. In a Spring Boot application, ViewModel can be implemented using:
   - Services to handle business logic.
   - Utility classes to transform and prepare responses.

4. **Controller**: Handles HTTP requests from the client, delegates processing to the ViewModel (Service), and returns responses in a structured format (e.g., JSON).

5. **Utils**: A set of helper classes and utilities used to format or prepare data, such as generating timestamps, formatting responses, or handling reusable logic.

---

## API Lifecycle in MVVM

### Request Flow:
1. **Client (View)**: Sends an HTTP request to the application.
2. **Controller**:
   - Receives the request and parses it.
   - Delegates the processing to the Service (ViewModel).
3. **Service (ViewModel)**:
   - Processes the request using business logic.
   - Interacts with the repository (Model) to fetch or manipulate data.
4. **Repository (Model)**:
   - Executes database queries.
   - Returns the results to the Service.
5. **Service**:
   - Formats the result (if needed).
   - Returns the prepared response to the Controller.
6. **Controller**:
   - Sends the response back to the client.

---

## API Endpoints

### 1. **Get All Employees**
- **URL**: `http://localhost:8080/api/employees`
- **Method**: `GET`
### 2. **POST All Employees**
- **URL**: `http://localhost:8080/api/employees`
- **Method**: `POST`
### 3. **PUT All Employees**
- **URL**: `http://localhost:8080/api/employees/{id}`
- **Method**: `PUT`
### 4. **DELETE All Employees**
- **URL**: `http://localhost:8080/api/employees/{id}`
- **Method**: `DELETE`
