# Etapa 1: Use uma imagem Maven para construir o projeto
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

# Etapa 2: Use a imagem OpenJDK para executar o JAR gerado
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copia o arquivo .jar gerado para o contêiner
COPY --from=build /app/target/sighas-be-1.0.0v.jar app.jar

# Define o comando para rodar o .jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]