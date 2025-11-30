FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8081
ADD target/AccountService.jar AccountService.jar
ENTRYPOINT ["java", "-jar", "AccountService.jar"]
