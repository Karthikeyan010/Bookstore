# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven build files
COPY pom.xml mvnw mvnw.cmd ./
COPY .mvn/ .mvn/

# Build application
RUN ./mvnw dependency:resolve
COPY src/ ./src/
RUN ./mvnw clean package -DskipTests

# Copy the built JAR file
COPY target/catalog-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
