# syntax=docker/dockerfile:1

FROM openjdk:21-jdk-slim

WORKDIR /app

COPY ./target/opensearchdemo-0.0.1-SNAPSHOT.jar ./app/ROOT.war

EXPOSE 8080

CMD ["java", "-jar",  "./app/ROOT.war"]
