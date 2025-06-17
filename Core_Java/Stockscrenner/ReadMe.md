# 📈 Stock Screener for Technical Analysis

A Spring Boot-based application that performs technical stock screening using external APIs. This project demonstrate backend design, secure API interaction, and real-time data processing using Java and Spring Boot technologies.

---

## 🧩 Features

- 🔐 **JWT Authentication**: Secures all stock-related endpoints. Users must register and log in to access the system.
- 🌐 **External API Integration**: Fetches real-time and historical stock data using `RestTemplate` and `ResponseEntity`.
- 📊 **Technical Analysis Metrics**:
  - Daily % change
  - 50-day High/Low
  - Moving averages (simple/rolling)
  - Custom screening logic
- 📁 **JPA-based Persistence**: Uses Spring Data JPA and an RDBMS (like MySQL) to store user and stock metadata.
- ✅ **REST APIs**: Cleanly designed endpoints for authentication and stock screening.
- 🛠️ **Modular structure** for controller, service, repository, and model layers.

---

## 🔧 Tech Stack

| Layer                | Technology                |
|---------------------|---------------------------|
| Language            | Java 17+                  |
| Framework           | Spring Boot               |
| Security            | Spring Security + JWT     |
| Data Access         | Spring Data JPA           |
| External API Access | RestTemplate, ResponseEntity |
| Build Tool          | Maven                     |
| Database            |  MySQL                    |


---

## 📌 Endpoints

### 🔐 Authentication
| Method | Endpoint           | Description       |
|--------|--------------------|-------------------|
| POST   | `/register`        | Register a new user |
| POST   | `/login`           | Authenticate and receive JWT |

### 📈 Stock Analysis
| Method | Endpoint                 | Description                   |
|--------|--------------------------|-------------------------------|
| GET    | `/stocks/{symbol}`       | Fetches analysis for symbol (secured) |
| GET    | `/stocks/analyze/{symbol}`   | Filters stocks by technical conditions |

