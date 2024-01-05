FROM openjdk:17-alpine
MAINTAINER boottechnologies.ci@gmail.com
WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# java -jar /app/spring-boot-docker.jar
CMD ["java", "-jar", "-Xmx1024M", "/app/app.jar"]

# Make port 8090 available to the world outside this container
EXPOSE 8081