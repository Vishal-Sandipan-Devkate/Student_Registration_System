# Student Registration Web Application

A simple Java web application for registering, listing, editing, and deleting student records using Java Servlet, JSP, and MySQL.

## Features

- Register a new student
- View all registered students
- Edit student details
- Delete a student record
- Basic HTML/CSS UI for a lightweight CRUD experience

## Tech Stack

- Java 17
- Maven
- Jakarta Servlet API
- JSP + JSTL
- MySQL
- Apache Tomcat (or any servlet container)

## Project Structure

```text
StudentRegistration/
├── pom.xml
├── README.md
├── src/
│   └── main/
│       ├── java/
│       │   └── com/student/
│       │       ├── controller/
│       │       ├── dao/
│       │       └── model/
│       └── webapp/
│           ├── css/
│           ├── register.jsp
│           ├── students.jsp
│           └── edit.jsp
└── target/
```

## Prerequisites

Before running this project, make sure you have:

- JDK 17+
- Maven
- MySQL Server
- Apache Tomcat 10+ (or another servlet-compatible server)

## Database Setup

Create a MySQL database and table:

```sql
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    course VARCHAR(100) NOT NULL
);
```

Then update the database credentials in:

`src/main/java/com/student/dao/DBConnection.java`

```java
private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
private static final String USER = "root";
private static final String PASSWORD = "Root@123";
```

You can replace these values with your own local MySQL credentials if needed.

## Build the Project

Run the following command from the project root:

```bash
mvn clean package
```

This will generate a WAR file in the `target` directory.

## Run the Application

1. Deploy the generated WAR file to Tomcat.
2. Start Tomcat.
3. Open the app in a browser.

Typical URL patterns:

```text
http://localhost:8080/StudentRegistration/register.jsp
http://localhost:8080/StudentRegistration/students
```

If your server is configured differently, adjust the context path accordingly.

## Main Servlet Endpoints

- `POST /Register` - register a new student
- `GET /students` - display all students
- `GET /edit?id=1` - open edit screen for a student
- `POST /update` - update student information
- `GET /delete?id=1` - delete a student

## Flow of the App

1. User opens the registration page.
2. Student details are submitted to `RegisterServlet`.
3. The data is inserted into the `students` table.
4. User is redirected to the list page.
5. Student records may be edited or deleted from the list.
