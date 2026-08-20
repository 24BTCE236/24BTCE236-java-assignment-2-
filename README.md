# Student Registration and Validation System

A complete Advanced Java and J2EE assignment built with **Java Servlets, JSP, JSTL, Maven, and Apache Tomcat**. Students enter their name, email ID, and course; the server validates every field and displays a safe confirmation page.

## Features

- Modern responsive student registration form
- Server-side validation for name, email, and course
- Clear field-level validation messages
- JSP views protected inside `WEB-INF`
- JSTL used for course rendering, conditions, and escaped output
- Session-based registration history and count
- Post/Redirect/Get flow to prevent duplicate form submission
- No database required

## Technologies

- Java 17
- Jakarta Servlet 6.0
- JSP and JSTL 3.0
- Maven
- Apache Tomcat 10.1+

## Run the project

1. Install Java 17, Maven, and Apache Tomcat 10.1 or newer.
2. Open a terminal in this project folder.
3. Build the WAR file:

   ```bash
   mvn clean package
   ```

4. Copy `target/student-registration-system.war` into Tomcat's `webapps` folder.
5. Start Tomcat and open:

   ```text
   http://localhost:8080/student-registration-system/
   ```

## Project structure

```text
src/main/java/com/nithish/student/
├── model/Student.java
└── servlet/
    ├── RegistrationServlet.java
    └── SuccessServlet.java

src/main/webapp/
├── assets/css/style.css
├── WEB-INF/views/register.jsp
├── WEB-INF/views/success.jsp
├── WEB-INF/web.xml
└── index.jsp
```

## Validation rules

- **Name:** required, 3–50 valid characters
- **Email:** required and must follow a valid email format
- **Course:** required and must match an available course

## Assignment concepts demonstrated

- Servlet lifecycle through `doGet()` and `doPost()`
- Request parameters and request attributes
- Request dispatching and HTTP redirects
- Session management
- JSP Expression Language
- JSTL `<c:if>`, `<c:forEach>`, and `<c:out>`
- MVC-style separation of model, controller, and view

Created for **Advanced Java and J2EE Assignment – 2**.
