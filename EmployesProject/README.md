# Employees Mini Project Backend

This is the Spring Boot backend for the EmployeesProject application. It provides a RESTful API for managing employee data and connects with the Angular frontend.

## 🛠 Tech Stack
- Java 24
- Spring Boot
- Maven
- Docker

## 📦 Features
- Get all employees
- Get employee by ID
- Add new employee
- Update employee
- Delete employee

## 🚀 Running the App

### ✅ Run Locally

To run the backend locally:

```bash
mvn clean install
mvn spring-boot:run
```

The API will be available at:  
`http://localhost:8081/api/employees`

---

### 🐳 Run with Docker

To build and run the Docker container:

```bash
docker build -t wafalasri/employesproject-backend .
docker run -p 8081:8081 wafalasri/employesproject-backend
```

---

## 🔗 Docker Hub

View the published Docker image:  
[https://hub.docker.com/r/wafalasri/employesproject-backend](https://hub.docker.com/r/wafalasri/employesproject-backend)
