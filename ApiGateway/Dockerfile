FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
ADD target/ApiGateway.jar ApiGateway.jar
ENTRYPOINT ["java", "-jar", "ApiGateway.jar"]
