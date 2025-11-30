FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8084
ADD target/ConfigServer.jar ConfigServer.jar
ENTRYPOINT ["java", "-jar", "ConfigServer.jar"]
