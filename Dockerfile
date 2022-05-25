FROM openjdk:11
VOLUME /tmp

EXPOSE 8080

COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

HEALTHCHECK --start-period=40s --interval=20s --timeout=5s --retries=5 \
            CMD curl --fail --silent http://localhost:8080/actuator/health | grep UP || exit 1