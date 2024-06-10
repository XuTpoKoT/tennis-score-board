# Табло теннисного матча
## Содержание
- [Описание](#desc)
- [Технологический стек](#frameworks)
- [Как запустить локально](#run)
- [Дизайн](#design)

<a name="desc"></a>
## Описание
Веб-приложение, реализующее табло счёта теннисного матча.
Каждый матч играется по следующим правилам:
- Матч играется до двух сетов (best of 3)
- Cет играется до 6 геймов
- При счёте 6/6 в сете, играется тай-брейк до 7 очков
- Гейм играется до 4 очков с перевесом в 2 очка

<a name="frameworks"></a>
## Технологический стек
- Java
- JSP
- Tomcat
- Hibernate
- Gradle
- PostgreSQL
- Flyway
- Lombok
- Mapstruct

<a name="run"></a>
## Как запустить локально
1. Установите переменную API_PORT в .env файле.
2. Запустите контейнер с приложением:
```
docker compose up -d
```
Приложение будет доступно по адресу http://localhost:API_PORT/tennis-score-board/main

<a name="design"></a>
## Дизайн
**Регистрация нового матча**
![auth](./img/new-match.png)

**Табло счёта идущего матча**
![score](./img/score.png)

**Страница завершенных матчей**
![finished](./img/finished-matches.png)