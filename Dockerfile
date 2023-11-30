FROM eclipse-temurin:latest
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
EXPOSE 8080

#//test