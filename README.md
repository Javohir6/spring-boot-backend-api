Spring Boot Backend API

A simple but complete Java backend built using **Spring Boot**, **Spring Data JPA**, and **H2 database**.

Features
- `POST /message` — Add a new message
- `GET /all` — Retrieve all messages
- `GET /message/{id}` — Get message by ID
- `PUT /message/{id}` — Update message text
- `DELETE /message/{id}` — Delete a message

Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 (in-memory DB)

How to Run Locally

```bash
./mvnw spring-boot:run
