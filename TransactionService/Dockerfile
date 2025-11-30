FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8082
ADD target/TransactionService.jar TransactionService.jar
ENTRYPOINT ["java", "-jar", "TransactionService.jar"]
