FROM openjdk:8
EXPOSE 8081
ADD target/spring-rest-user.jar spring-rest-user.jar
ENTRYPOINT ["java", "-jar", "spring-rest-user.jar"]