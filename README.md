# autoloc-api

> [!WARNING]
> **Database credentials are committed in `src/main/resources/application.properties`.**
> It points to MySQL at `localhost:3306`, database `autoloc_db`, user `webadmin`, empty password.
> Another device will only start the app if it has a matching MySQL instance and user, and **JDK 25** installed.
> Do not commit real or production credentials; override them locally for your environment.

## Overview

Spring Boot 4.1.1 REST API for a car rental (auto-location) service, built with Java 25 and Maven.

Layered structure:

- `domain` — JPA entities and enums
- `repository` — Spring Data JPA repositories
- `service` — business logic (interfaces + implementations)
- `web/controller` — REST controllers

## Prerequisites

- JDK 25
- MySQL running locally on port `3306`
- Network access on first run (the Maven wrapper downloads Maven 3.9.16)

## Run

Open the project folder or `pom.xml` in IntelliJ IDEA (it regenerates the ignored `.idea` config and imports the Maven project), then run `AutolocApiApplication`.

Or from the command line:

```bash
./mvnw spring-boot:run
```

Windows:

```bat
mvnw.cmd spring-boot:run
```

## Notes

- `.idea/`, `target/`, `HELP.md`, and `.mvn/wrapper/maven-wrapper.jar` are ignored intentionally.
- The Maven wrapper is script-only, so no wrapper jar is needed.
