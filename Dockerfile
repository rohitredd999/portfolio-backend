# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests package

# ---- Runtime stage ----
FROM eclipse-temurin:17-jre
WORKDIR /app

# Render sets PORT automatically; your application.yaml uses ${PORT:8080}
ENV PORT=8080
EXPOSE 8080

COPY --from=builder /app/target/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
