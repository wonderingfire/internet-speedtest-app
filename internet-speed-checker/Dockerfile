FROM openjdk:17 AS base
LABEL authors="nathanielchavez"

WORKDIR /internet-speed-checker
CMD ["./gradlew", "clean", "bootJar"]

COPY build/libs/internet-speed-checker-0.0.1-SNAPSHOT.jar app.jar

FROM base AS dev

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
