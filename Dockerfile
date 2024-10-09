FROM openjdk:17-alpine

WORKDIR /app

COPY /target/tic-tac-toe.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]