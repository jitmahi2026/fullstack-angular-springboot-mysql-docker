FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

RUN apt-get update && apt-get install -y netcat

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh","-c", "\
  echo 'Waiting for MySQL...'; \
  while ! nc -z fullstack-app-mysql-1 3306; do \
    sleep 3; \
  done; \
  echo 'MySQL is ready! Starting app...'; \
  java -jar app.jar \
"]