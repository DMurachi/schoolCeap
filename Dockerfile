FROM openjdk:11-jre

ENTRYPOINT ["/usr/bin/java", "-jar", "/opt/boilerplate/boilerplate-app.jar", "--spring.config.location=classpath:/application.properties,file:/opt/boilerplate/config/application.properties"]

ARG JAR_FILE
ADD target/${JAR_FILE} /opt/boilerplate/boilerplate-app.jar

RUN mkdir -p /opt/boilerplate/logs/