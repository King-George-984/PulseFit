# PulseFit – Smart Gym Management System

A microservices-based gym management application designed to manage members, subscriptions, attendance, authentication and fitness facility operations across multiple fitness centers.

## Project Overview

PulseFit is a backend-focused application developed using Spring Boot and Microservices Architecture. It separates major gym management functionalities into independent services to improve modularity, maintainability and scalability.

The project implements centralized API routing, service discovery, JWT-based authentication and RESTful API operations.

## Architecture

The application consists of six independently developed components:

| Component | Responsibility |
|---|---|
| API Gateway | Central entry point for client requests and API routing |
| Eureka Server | Service registration and discovery |
| Auth Service | User authentication and JWT token generation |
| Member Service | Member registration, profiles and CRUD operations |
| Attendance Service | Attendance records and check-in management |
| Subscription Service | Membership plans, subscriptions and related operations |

## Technology Stack

- **Programming Language:** Java
- **Backend Framework:** Spring Boot
- **Architecture:** Microservices
- **Service Discovery:** Netflix Eureka
- **API Gateway:** Spring Cloud Gateway
- **Authentication:** JWT
- **Database:** PostgreSQL
- **API Testing:** Postman
- **Development Environment:** Spring Tool Suite (STS)
- **Version Control:** Git and GitHub

## Key Features

### 1. Authentication and Authorization
- User login and JWT token generation.
- Token-based access to protected endpoints.
- Unauthorized requests are rejected.

### 2. Member Management
- Create member records.
- Retrieve member information.
- Update existing member records.
- Delete member records.

### 3. Attendance Management
- Attendance-related REST API operations.
- Protected access through authentication.

### 4. Subscription Management
- Separate service for membership plans and subscription operations.

### 5. Service Discovery
- Eureka Server enables service registration and discovery.

### 6. API Gateway
- Centralized entry point for incoming requests.
- Routes requests to the appropriate backend services.

## Architecture Flow

```text
                 Client / Postman
                        |
                        v
                  API Gateway
                        |
          +-------------+-------------+
          |             |             |
          v             v             v
       Auth          Member       Attendance
       Service       Service       Service
          |             |             |
          |             |             |
          |             v             |
          |         PostgreSQL        |
          |                           |
          +-------------+-------------+
                        |
                        v
                Subscription Service

                 Eureka Server
              (Service Discovery)
```

*Conceptual architecture illustration. Confirm the actual service-to-service communication and database connections against the implementation before treating this as the final architecture diagram.*

## Testing and Validation

The application was tested using Postman.

The following scenarios were successfully tested during project development:

- JWT login and token generation.
- Successful access to protected Member and Attendance endpoints.
- Rejection of requests without authentication.
- Member creation using POST.
- Member retrieval using GET.
- Member updates using PUT.
- Load-balancing test with requests reaching both service instances.

## Learning Outcomes

- Practical implementation of microservices architecture.
- Developing RESTful APIs using Spring Boot.
- Implementing JWT-based authentication.
- Understanding API Gateway and service discovery.
- Working with PostgreSQL database integration.
- Testing and troubleshooting distributed backend services.
- Managing source code using Git and GitHub.

## Repository

GitHub: https://github.com/King-George-984/PulseFit

## Future Enhancements

- Add automated unit and integration testing.
- Introduce centralized logging and monitoring.
- Add Docker-based deployment.
- Improve service resilience and fault handling.
- Add API documentation using Swagger/OpenAPI.

---

**Project:** PulseFit – Smart Gym Management System  
**Developer:** Kalavakollu King George  
**Architecture:** Microservices  
**Status:** Academic project implementation and testing completed; further enhancements can be added.
