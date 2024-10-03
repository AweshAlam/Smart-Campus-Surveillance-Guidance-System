# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from your target directory to the container
COPY target/Smart-Campus-Surveillance-and-Guidence-System-0.0.1-SNAPSHOT.jar /app/Smart-Campus-Surveillance-and-Guidence-System-0.0.1-SNAPSHOT.jar

# Expose the port that your Spring Boot application runs on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/Smart-Campus-Surveillance-and-Guidence-System-0.0.1-SNAPSHOT.jar"]