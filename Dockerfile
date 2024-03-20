FROM openjdk:17-jdk-slim-buster

ADD target/*.jar application.jar

ENTRYPOINT [ "java", "-jar", "application.jar" ]

EXPOSE 80:80