# 🎉 Event Management System API

Welcome! 👋  
This is a **Spring Boot-based RESTful Event Management System** designed to manage events efficiently.

The application supports **creating, viewing, updating, and deleting events** with proper layered architecture, exception handling, and unit testing.

It’s built to be **simple, clean, and scalable**.

---

## 🚀 Key Features

- RESTful API design  
- Layered Architecture (Controller, Service, Repository)  
- Global Exception Handling  
- Unit Testing  
- Easy configuration using application.properties  

---

## 🛠 Tech Stack

**Backend:** Java, Spring Boot  
**ORM:** Spring Data JPA (Hibernate)  
**Database:** MySQL (or any JPA-supported DB)  
**Build Tool:** Maven  
**Testing:** JUnit  

---

## 📦 Project Structure

```
src/main/java/com/example/EventManagement/
├── EventManagementApplication.java
├── controller/
│   └── EventController.java
├── service/
│   ├── EventService.java
│   └── EventServiceImplementation.java
├── repository/
│   └── EventRepository.java
├── model/
│   └── Event.java
└── exception/
    ├── EventNotFoundException.java
    └── GlobalExceptionHandler.java

src/test/java/com/example/EventManagement/
├── EventManagementApplicationTests.java
└── EventServiceImplementationTest.java
```

---

## 🔌 API Endpoints

| HTTP Method | Endpoint        | Description        |
|------------|----------------|-------------------|
| POST       | /events         | Create new event |
| GET        | /events         | Get all events |
| GET        | /events/{id}    | Get event by ID |
| PUT        | /events/{id}    | Update event |
| DELETE     | /events/{id}    | Delete event |

---

## 🗄 Database Structure (Event Table)

Based on your Event entity:

### 📋 Table: event

| Column Name | Data Type | Description |
|------------|---------|-------------|
| id | BIGINT (Primary Key) | Auto-generated event ID |
| name | VARCHAR(255) | Event name |
| description | VARCHAR(255) | Event description |
| location | VARCHAR(255) | Event location |
| date | DATETIME | Event date and time |

---

## 📌 Sample SQL Schema

```sql
CREATE TABLE event (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    location VARCHAR(255),
    date DATETIME
);
```

---

## ⚙ Configuration

Edit database configuration in:

```
src/main/resources/application.properties
```

### Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/eventmanagement
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone <your-repository-url>
```

### 2️⃣ Navigate into project

```bash
cd EventManagement
```

### 3️⃣ Run application

```bash
mvn spring-boot:run
```

OR run:

```
EventManagementApplication.java
```

from your IDE.

---

## 🧪 Run Tests

```bash
mvn test
```

---

## 👨‍💻 Author

**Dileep Kumar**  
Java Full Stack Developer  

---

## 📬 Questions?

Feel free to explore the project!  
The code is structured cleanly for easy understanding and future scalability.

---

⭐ If you find this project helpful, don’t forget to give it a star!
