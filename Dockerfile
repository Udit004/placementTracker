# Stage 1: Build
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy pom.xml and download dependencies (for caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copy the built jar from the build stage
# The jar name is typically artifactId-version.jar
COPY --from=build /app/target/placementtracker-0.0.1-SNAPSHOT.jar app.jar

# Render uses the PORT environment variable
ENV PORT=8080
EXPOSE ${PORT}

# Run the application
# Render uses the PORT environment variable, we pass it to Spring Boot
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]
