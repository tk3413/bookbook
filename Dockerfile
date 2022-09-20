FROM openjdk:11
COPY target/bookbook-0.0.1-SNAPSHOT.jar /home/bookbook/bookbook.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/bookbook/bookbook.jar"]