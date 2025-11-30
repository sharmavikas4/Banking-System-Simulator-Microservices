FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8083
ADD target/NotificationService.jar NotificationService.jar
ENTRYPOINT ["java", "-jar", "NotificationService.jar"]
