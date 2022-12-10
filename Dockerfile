FROM adoptopenjdk/openjdk11:latest
MAINTAINER group.eureka.com
VOLUME /tmp
EXPOSE 18083
ADD target/user-0.0.1-SNAPSHOT.jar user-grupo2.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/user-grupo2.jar"]
