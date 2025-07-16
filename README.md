# 👥 Employees Mini Project

A full-stack employee management system with a Spring Boot REST API backend and Angular frontend. Fully Dockerized and ready to deploy using Docker Compose.

---

## 🛠️ Tech Stack

- **Frontend:** Angular, TypeScript, HTML/CSS, NGINX
- **Backend:** Spring Boot (Java), Maven
- **Containerization:** Docker, Docker Compose

---

## 🎯 Features

### 🔹 Frontend (Angular)
- View list of employees
- Add new employee
- Edit existing employee
- Delete employee

### 🔹 Backend (Spring Boot)
- RESTful APIs for employee CRUD operations
- DTOs, services, repositories structure
- CORS configured for frontend integration

---

## 🚀 How to Run

### ✅ Option 1: Run with Docker Hub Images (Recommended)

Make sure Docker is installed and running.

```bash
docker compose -f docker-compose.prod.yml up
```

This uses prebuilt images from Docker Hub:

```bash
services:
  
  frontend:
    image: wafalasri/employesproject-frontend:1.0
    ports:
      - "4200:80"
    depends_on:
      - springboot

  springboot:
    image: wafalasri/employesproject-backend:1.0
    ports:
      - "8081:8081"

networks:
  default:
    driver: bridge
```

Access the app at: http://localhost:4200

### ✅ Option 2: Build and Run Locally

1. Clone the repo

```bash
git clone https://github.com/LasriWafa/Employees-Mini-Project.git
cd Employees-Mini-Project
```

2. Build Docker images

```bash
# Backend
cd EmployesProject
docker build -t wafalasri/employesproject-backend .
cd ..

# Frontend
cd my-app
docker build -t wafalasri/employesproject-frontend .
cd ..
```

3. Run using local images

```bash
docker compose up
```

#### docker-compose.yml:

```bash
services:

  springboot:
    build:
      context: ./EmployesProject
      dockerfile: Dockerfile
    container_name: employeesproject-backend
    ports:
      - "8081:8081"
    networks:
      - employee-network

  frontend:
    build:
      context: ./my-app
      dockerfile: Dockerfile
    container_name: employeesproject-frontend
    ports:
      - "4200:80"
    depends_on:
      - springboot
    networks:
      - employee-network

networks:
  employee-network:
    driver: bridge

```

## 📁 Project Structure
<pre lang="text">
    <code> 
        Employees-Mini-Project/ 
        ├── EmployesProject/        # Spring Boot Backend 
        │   ├── Dockerfile 
        │   └── README.md 
        ├── my-app/                 # Angular Frontend 
        │   ├── Dockerfile 
        │   ├── nginx.conf 
        │   └── README.md 
        ├── docker-compose.yml      # Compose for local build 
        └── README.md               # Main project README 
    </code>
</pre>

## 📦 Docker Hub Images

| Component | Docker Hub Link                                                                                     |
| --------- | --------------------------------------------------------------------------------------------------- |
| Frontend  | [`wafalasri/employesproject-frontend`](https://hub.docker.com/r/wafalasri/employesproject-frontend) |
| Backend   | [`wafalasri/employesproject-backend`](https://hub.docker.com/r/wafalasri/employesproject-backend)   |

Pull manually if needed:

```bash
docker pull wafalasri/employesproject-frontend:1.0
docker pull wafalasri/employesproject-backend:1.0
```

## 👤 Author
Wafa LASRI
- 🎓 Computer Science Student | 👩‍💻 Aspiring Full-Stack Developer
- 🔗 GitHub
- 🐳 Docker Hub


## 📜 License
This project is for educational and demonstration purposes.
