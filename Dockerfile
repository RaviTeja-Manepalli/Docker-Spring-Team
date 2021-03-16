From  openjdk:8-jre-alpine
ADD target/Team-0.0.1-SNAPSHOT.jar team-docker.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar" , "team-docker.jar"]
