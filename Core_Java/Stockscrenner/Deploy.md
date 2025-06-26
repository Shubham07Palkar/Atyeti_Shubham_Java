# 🚀 Spring Boot + MySQL Deployment Guide (Render + GitHub Actions)

---

## ✅ Step 1: Prepare Spring Boot App

Update `application.properties`:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

Package locally:
```bash
./mvnw clean package
```

---

## ✅ Step 2: Setup Cloud MySQL (PlanetScale)

1. Go to [https://planetscale.com](https://planetscale.com)
2. Create a new database → enable **password authentication**
3. Copy your:
   - Host
   - Username
   - Password
   - Database name

**JDBC Format:**
```properties
jdbc:mysql://<host>:3306/<db>?sslMode=REQUIRED
```

---

## ✅ Step 3: Deploy Spring Boot to Render

1. Push project to GitHub:
```bash
git init
git remote add origin https://github.com/your-username/your-repo.git
git add .
git commit -m "Initial commit"
git push -u origin main
```

2. Go to [https://render.com](https://render.com)
3. Create a **Web Service**:
   - Build Command: `./mvnw clean install`
   - Start Command: `java -jar target/your-app-name.jar`

4. Add Environment Variables:
   - `DB_URL`
   - `DB_USERNAME`
   - `DB_PASSWORD`

Render will deploy and give a public URL:
```
https://your-app.onrender.com/api/...
```

---

## ✅ Step 4: Enable Auto-Deploy

1. Render auto-deploys on every push to the connected GitHub repo
2. Confirm in **Settings → Deploys → Auto Deploy = ON**

---

## ✅ Step 5: GitHub Actions CI Workflow

Create `.github/workflows/ci.yml`:

```yaml
name: Spring Boot CI

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4

      - uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'

      - uses: actions/cache@v3
        with:
          path: ~/.m2
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            ${{ runner.os }}-m2

      - run: ./mvnw clean install
      - run: ./mvnw test
```

Push to GitHub and monitor builds under the **Actions** tab.

---

## 🧾 Summary

| Feature         | Setup Status |
|----------------|--------------|
| Spring Boot App | ✅ Ready      |
| Cloud MySQL     | ✅ PlanetScale|
| Hosting         | ✅ Render     |
| CI/CD           | ✅ GitHub Actions |
| Auto Deploy     | ✅ Enabled    |

---

