FROM openjdk:8-slim-buster
LABEL author="netbuffer"
WORKDIR /
ADD target/server-test-webapp.jar /
EXPOSE 9100
ENV PROJECT_DEFAULT_NAME=server-test-app PROJECT_DEFAULT_VERSION=v1.0.0
ENTRYPOINT java ${JAVA_OPTS} -jar /server-test-webapp.jar
