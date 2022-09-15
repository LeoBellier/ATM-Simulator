FROM openjdk:17-jdk-alpine

WORKDIR /app


RUN ./mvnw dependency:go-offline

COPY ["src", "./src"]

CMD ["./mvnw", "spring-boot:run"]
