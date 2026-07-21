# Use an official Java runtime as a parent image
FROM eclipse-temurin:21-jre-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from Jenkins workspace into the container
COPY target/expense-tracker-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8081"]
