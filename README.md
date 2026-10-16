# SamsungSmallProjectFotBackendTest

Небольшой учебный REST-сервис для операций с пользователями на Java 21 и Spring Boot 3.3.6. Использует Spring Data JPA и файловую базу H2.

## Запуск

Требуется JDK 21. Выполните из корня:

```sh
sh gradlew bootRun
```

В Windows: `gradlew.bat bootRun`. При стандартной конфигурации Spring Boot сервер доступен на `http://localhost:8080`; Swagger UI — `/docs`. Настройки — `src/main/resources/application.properties`, файлы H2 создаются рядом с `./data`.

## API

Все операции используют `/store/user`:

- `POST` — создать пользователя, JSON по модели `CreateUserDto`.
- `PUT` — обновить пользователя, JSON по той же модели.
- `GET ?id=...` — получить пользователя.
- `DELETE ?id=...` — удалить пользователя.

Контроллер, сервис, сущность и DTO находятся в `src/main/java/com/example/samsungsmallprojectfotbackendtest/user/`.
