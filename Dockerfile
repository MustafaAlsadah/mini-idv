FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/mini-idv-0.0.1-SNAPSHOT.jar app.jar

ENV PORT=8080

EXPOSE ${PORT}

# Use ENTRYPOINT with shell form to ensure environment variables are expanded
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT}"]