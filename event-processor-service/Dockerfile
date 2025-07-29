FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y maven

WORKDIR /app
COPY ./src ./src
COPY ./pom.xml .

RUN mvn clean package -DskipTests

EXPOSE 8081
CMD ["java", "-jar", "target/event-processor-service-1.0-SNAPSHOT.jar"]
