FROM openjdk:8
EXPOSE 8081
ADD target/spring-user-0.0.1-SNAPSHOT.jar spring-rest-user.jar
ENTRYPOINT ["java", "-jar", "spring-rest-user.jar"]