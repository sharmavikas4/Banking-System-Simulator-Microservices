FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8761
ADD target/EurekaServer.jar EurekaServer.jar
ENTRYPOINT ["java", "-jar", "EurekaServer.jar"]
