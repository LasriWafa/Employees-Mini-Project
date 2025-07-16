# Employees Mini Project Frontend

This is the Angular frontend for the EmployeesProject application. It consumes REST APIs exposed by the Spring Boot backend to manage employee data.

## 🛠 Tech Stack
- Angular (v19.2.15)
- TypeScript
- HTML/CSS
- Docker
- NGINX

## 📦 Features
- View all employees
- Add a new employee
- Edit an existing employee
- Delete an employee

## 🚀 Running the App

### ✅ Development Server

To start the app locally for development:

```bash
npm install
ng serve
```

Then open your browser at `http://localhost:4200/`.

The application will auto-reload on source file changes.

---

### 🐳 Run with Docker

To build and run the Docker container:

```bash
docker build -t wafalasri/employesproject-frontend .
docker run -p 4200:80 wafalasri/employesproject-frontend
```

Make sure your **backend** is running at `http://localhost:8081/api`.

---

## 🔗 Docker Hub

View the published Docker image:  
[https://hub.docker.com/r/wafalasri/employesproject-frontend](https://hub.docker.com/r/wafalasri/employesproject-frontend)