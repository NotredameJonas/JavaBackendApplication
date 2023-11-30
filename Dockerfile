FROM openjdk:21-jdk

WORKDIR /app

# Copy only necessary files
COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]