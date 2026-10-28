# TableTrail — Restaurant Reservation API

A beginner-friendly REST API for managing restaurant reservations with Java 21, Spring Boot, Spring Data JPA, and MySQL.

## Features
- Create, list, retrieve, update, and delete reservations
- Validate customer name, email, reservation time, and party size
- Persist records in MySQL using Spring Data JPA
- Return useful HTTP status codes for successful operations and errors

## Run locally
1. Install JDK 21, Maven, and MySQL 8+.
2. Configure `DB_USERNAME` and `DB_PASSWORD` or update `application.properties`.
3. Run `mvn spring-boot:run`.
4. Base URL: `http://localhost:8080`.

## Endpoints
| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/reservations` | List reservations |
| GET | `/api/reservations/{id}` | Retrieve a reservation |
| POST | `/api/reservations` | Create a reservation |
| PUT | `/api/reservations/{id}` | Update a reservation |
| DELETE | `/api/reservations/{id}` | Delete a reservation |

## Example request
```json
{"customerName":"Aarav Patil","email":"aarav@example.com","reservationTime":"2026-11-15T19:30:00","partySize":4,"specialRequest":"Window seat if available"}
```
Do not commit real database credentials to GitHub.
