# Webtools Email Microservice

A Spring Boot-based microservice designed to handle email sending operations within the webtools ecosystem.

## Features

- **Email Delivery**: Send emails with support for body content and file attachments.
- **Service Discovery**: Integrated with Netflix Eureka for seamless service registration and discovery.
- **Centralized Configuration**: Uses Spring Cloud Config for managing environment-specific properties.
- **Observability**: 
    - **Actuator**: Health checks and application metrics.
    - **Distributed Tracing**: Integrated with Micrometer Tracing and Zipkin for request tracking across services.
- **API Documentation**: Auto-generated OpenAPI/Swagger UI for easy API exploration.

## Tech Stack

- **Language**: Java 21
- **Framework**: Spring Boot 3.4.2
- **Cloud**: Spring Cloud 2024.0.0
- **Build Tool**: Maven
- **Utilities**: Lombok, Spring Boot Starter Mail, SpringDoc OpenAPI

## Getting Started

### Prerequisites

- JDK 21
- Maven (or use the provided `./mvnw` wrapper)

### Build and Run

1. **Clone the repository**
2. **Build the project**:
   ```bash
   ./mvnw clean install
   ```
3. **Run the application**:
   ```bash
   ./mvnw spring-boot:run
   ```

## API Reference

### Send Email
`POST /v1`

**Request Body** (`EmailDetails`):
| Field | Type | Description |
| :--- | :--- | :--- |
| `recipient` | String | Email address of the recipient |
| `subject` | String | Subject line of the email |
| `msgBody` | String | Main content of the email |
| `attachement` | String | (Optional) Absolute path to the file to be attached |

**Example Request**:
```json
{
  "recipient": "user@example.com",
  "subject": "Hello from Webtools",
  "msgBody": "This is a test email sent via the Webtools Email microservice.",
  "attachement": "/tmp/report.pdf"
}
```

**Response**:
- `200 OK`: "Mail Sent Successfully"

## Deployment

The project includes infrastructure files for automated deployment:
- `Dockerfile`: For containerization.
- `Jenkinsfile`: For CI/CD pipeline automation.
- `Deploy-webtools-email-private.yaml`: Kubernetes manifest for deployment.
