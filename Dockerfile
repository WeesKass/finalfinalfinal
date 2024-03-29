FROM java:8
FROM maven:alpine

WORKDIR /app

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
LABEL maintainer='weeskass@gmail.com'
ADD ./target/kotlin-final-0.0.1-SNAPSHOT.jar kotlin-final-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","kotlin-final-0.0.1-SNAPSHOT.jar"]

#FROM openjdk:8-jdk-alpine
#EXPOSE 8080
#ADD /build/libs/dockerdemo-0.0.1-SNAPSHOT.jar dockerdemo.jar
#ENTRYPOINT ["java", "-jar", "dockerdemo.jar"]