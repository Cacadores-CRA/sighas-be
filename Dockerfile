#Building project
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /opt/sighas-be
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

#Running project with JDK 21
FROM eclipse-temurin:21

EXPOSE 8080

WORKDIR /opt/sighas-be
COPY --from=build /opt/sighas-be/target/sighas-be-1.0.0v.jar app.jar
ENTRYPOINT ["java", "-jar", "/opt/sighas-be/app.jar"]
