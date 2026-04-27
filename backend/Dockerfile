FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Dserver.address=0.0.0.0","-Dserver.port=8080","-jar","app.jar"]