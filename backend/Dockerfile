# Stage 1: Build jar
FROM maven:3.9.8-eclipse-temurin-17 AS build

WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Create uploads directory (IMPORTANT)
RUN mkdir -p /app/uploads && chmod -R 777 /app/uploads

# Stage 2: Run app
FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]