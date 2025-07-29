FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY ./src /app/src
COPY ./pom.xml /app/pom.xml

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/user-activity-service-1.0-SNAPSHOT.jar"]
