# Use a base image with JDK
FROM openjdk:17-jdk

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar flight-services.jar

# Expose the port the app runs on
EXPOSE 8000

# Run the application
ENTRYPOINT ["java", "-jar", "flight-services.jar"]
