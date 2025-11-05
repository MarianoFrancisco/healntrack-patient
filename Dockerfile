FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY patient-service/pom.xml .

COPY patient-service/src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/patient-service-1.0.0.jar app.jar

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "app.jar"]
