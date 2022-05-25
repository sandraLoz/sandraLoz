FROM openjdk:11
ARG JAR_FILE=*.jar
EXPOSE 8080
COPY ${JAR_FILE} demoUser-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","target/demoUser-0.0.1-SNAPSHOT.jar"]