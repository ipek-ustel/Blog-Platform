# Personal Blogging Platform 

A full-stack personal blogging web application built with **Spring Boot 3**, **Spring Data JPA**, **MySQL**, and a responsive **HTML5/CSS3/JavaScript** frontend featuring a dark theme.

---

## Features

* **Complete CRUD Operations:** Create, read, update, and delete blog posts.
* **Smart Search:** Search across post titles, contents, and categories.
* **Tag System & Hashtag Cloud:** Add tags to articles and click any `#tag` badge to filter posts instantly.
* **Timestamps:** Automated ISO-8601 creation (`createdAt`) and update (`updatedAt`) dates powered by Hibernate.
* **Input Validation & Error Handling:** Clean JSON error messages on invalid submissions (`400 Bad Request`) and missing records (`404 Not Found`).

---

## Prerequisites

* **Java Development Kit (JDK 21)**
* **MySQL Server 8+** (or MySQL Workbench)

---

## Database Setup

1. Start your local MySQL service.
2. Run the following command in MySQL Workbench or via the terminal:

```sql
CREATE DATABASE blog_db;
```

---

## Configuration

The database credentials in `src/main/resources/application.properties` are managed securely via environment variables:

```sql
spring.datasource.password=${DB_PASSWORD}
```
Set "DB_PASSWORD" to your local MySQL root user password before launching the application.

---

## Opening the Blog Site in Your Browser

1. Run BlogApplication.
2. Open your web browser.

Navigate to: http://localhost:8080/

---

Project idea from: https://roadmap.sh/projects/markdown-note-taking-app
