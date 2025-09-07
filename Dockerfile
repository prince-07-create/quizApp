# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml to leverage Docker cache
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Add execute permissions to the mvnw script
RUN chmod +x ./mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of your application's source code
COPY src ./src

# Package the application, skipping tests for faster builds
RUN ./mvnw package -DskipTests

# Final stage to create a smaller final image
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the packaged jar from the build stage (Update the filename if yours is different)
COPY --from=0 /app/target/quizApp-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port the app runs on (Spring Boot default is 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]