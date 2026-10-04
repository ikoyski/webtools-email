# CLAUDE.md - Webtools Email

## Build and Test Commands

- **Build Project**: `./mvnw clean install`
- **Run Tests**: `./mvnw test`
- **Run Application**: `./mvnw spring-boot:run`
- **Clean Build**: `./mvnw clean`

## Code Style and Guidelines

### Architectural Patterns
- **Layered Architecture**: Follow the `Controller` $\rightarrow$ `Service` $\rightarrow$ `Service Implementation` pattern.
- **DTOs**: Use Data Transfer Objects (DTOs) for request and response bodies (located in `com.ikoyski.webtools.email.dto`).
- **Dependency Injection**: Use constructor injection for services and components.

### Coding Standards
- **Boilerplate**: Use Lombok annotations (`@Data`, `@Getter`, `@Setter`, etc.) to reduce boilerplate code.
- **Error Handling**: Throw appropriate exceptions (e.g., `MessagingException`) and handle them at the controller or global exception handler level.
- **Naming**:
    - Controllers: `*Controller`
    - Services: `*Service` (interface) and `*ServiceImpl` (implementation).
    - DTOs: `*Details` or `*Request`/`*Response`.

### Testing Guidelines
- **Location**: Tests must be placed in `src/test/java` mirroring the main package structure.
- **Coverage**: Every new service or controller method should have a corresponding JUnit test.
- **Mocks**: Use Mockito for mocking dependencies in unit tests.

## Project Structure

- `src/main/java/com/ikoyski/webtools/email/`:
    - `controller/`: REST endpoints.
    - `service/`: Business logic interfaces and implementations.
    - `dto/`: Request/Response objects.
- `src/main/resources/`: Configuration files (`application.yaml`).
- `src/test/java/`: JUnit and Mockito tests.
