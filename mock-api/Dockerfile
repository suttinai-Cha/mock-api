# Use official base image of Java Runtim
FROM openjdk:8-jdk-alpine

# Set volume point to /tmp
VOLUME /tmp

# Make port 8081 available to the world outside container
EXPOSE 8090

# Set application's JAR file
ARG JAR_FILE=target/mock-api-0.0.1-SNAPSHOT.jar

# Add the application's JAR file to the container
ADD ${JAR_FILE} app.jar

# Run the JAR file
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=qcat", "-jar", "/app.jar"]