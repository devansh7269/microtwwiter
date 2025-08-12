# Micro Twitter - Mini Social Feed

A small demo project: Spring Boot backend + H2 database + static frontend (index.html).

## Requirements
- Java 17 installed
- Maven installed

## Run locally
1. Open a terminal in the project folder.
2. Build & run:
   ```
   mvn spring-boot:run
   ```
3. Open http://localhost:8080 in your browser.
4. H2 console is available at http://localhost:8080/h2-console (JDBC URL: jdbc:h2:file:./data/microdb)

## Notes
- Posts are saved to a local H2 file database at `./data/microdb.*` so data persists between runs.
- This is a simple demo. For production you should add authentication, input validation, rate limits, and host on a proper server.
