# ---- Build stage ----
FROM maven:3.9-eclipse-temurin-21 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -DskipTests package

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app
ENV PORT=8080
EXPOSE 8080
COPY --from=builder /app/target/*.jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
