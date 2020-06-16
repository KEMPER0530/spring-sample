FROM openjdk:8-jre
MAINTAINER kemper0530

# app.jarの再配置
COPY ./release/spring-sample-1.0.0.jar /

ENTRYPOINT ["java","-jar","spring-sample-1.0.0.jar"]
