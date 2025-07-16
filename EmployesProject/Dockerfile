# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:24-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR built in Step 1 into the container
COPY target/EmployesProject-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the Spring Boot app listens on
EXPOSE 8081

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]