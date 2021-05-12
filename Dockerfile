FROM maven:3.6.3-openjdk-11 AS MAVEN_BUILD

COPY pom.xml /build/
COPY src /build/src/

WORKDIR /build/
RUN mvn package

FROM openjdk:8-jre


WORKDIR /app

COPY --from=MAVEN_BUILD /build/target/*.jar /app/profile-app.jar

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "profile-app.jar"]