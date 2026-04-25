FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

RUN apt-get update && apt-get install -y netcat

COPY target/*.jar app.jar

ENTRYPOINT ["sh", "-c", "echo 'Waiting for MySQL...'; sleep 30; java -jar app.jar"]