### 1. Запуск
```
make compose-up
```

### 2. Подключение к Postgres

```
Открыть в браузере http://127.0.0.1:8080/

INITIAL SERVER CONFIGURATION -> next

Login: administrator
Password: Password123

next, finish

Ввести administrator, Password123
login

Открыть
http://127.0.0.1:8080/#

Connection -> New connection
PostgreSQL
Host: postgres
Post: 5432
Database: postgres
User name: postgres
User password: postgres
[x] Save credentials

Test, Create
```

### 3. Скрипты

```
init.sql - создание таблиц
examples.sql - примеры запросов
```

### 7. Остановка
```
make compose-down
```
