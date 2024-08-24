# Use a base image with JDK
FROM openjdk:17-jdk

# Set the working directory
WORKDIR /opt

# Expose the port the app runs on
EXPOSE 8000

# Copy the JAR file into the container,COPY target/*.jar /opt/app.jar
COPY target/*.jar /opt/flight-services.jar

ENTRYPOINT exec java $JAVA_OPTS -jar flight-services.jar

