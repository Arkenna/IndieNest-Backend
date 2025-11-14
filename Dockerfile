FROM mcr.microsoft.com/openjdk/jdk:25-ubuntu
WORKDIR /app
COPY target/backend-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]