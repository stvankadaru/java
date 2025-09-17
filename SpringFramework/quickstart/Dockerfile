FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/*.jar quickstart.jar
ENTRYPOINT ["java" , "-jar" , "/quickstart.jar"]