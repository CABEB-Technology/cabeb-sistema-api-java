FROM openjdk:17

ADD target/java-0.0.1-SNAPSHOT.jar cabeb_sistema_api

ENTRYPOINT [ "java", "-jar", "cabeb_sistema_api" ]

EXPOSE 5000