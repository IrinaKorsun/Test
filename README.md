# Описание модулей проекта
Проект состоит из двух блоков 

* db
* book

Модуль db содержит скрипты для проливки основных таблиц на базу данных

Для работы c in memory базой данных ими пользоваться нет смысла, 
достаточно запустить приложение командой
>./gradlew bootrun

Для работы с persistent базой можно воспрользоваться проливкой скриптов для первой версии,
выполнив команду

>./gradlew db:liquibaseUpdate

Более подробное описание читай в Readme.md модуля db

# Запуск приложения
Команда для запуска приложения: 
>./gradlew bootrun

Команда для запуска тестов: 
>./gradlew test

# Swagger Api Documentation
После запуска документация доступны по ссылке: http://localhost:8080/swagger-ui/

# Доступ к базе данных
Приложение запускается с h2 in memory database
После запуска клиент БД доступе по ссылке: http://localhost:8080/h2-console/login.jsp

Креды для подключения к h2:

>JDBC url: jdbc:h2:mem:testdb
> 
>password : password


# Основные сценарии
Для прогона основных пользовательских сценариев можно воспользоваться файлом:
>generated-request.http


