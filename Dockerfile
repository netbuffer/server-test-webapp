FROM openjdk:8-jdk
LABEL author="netbuffer"
WORKDIR /
ADD target/server-test-webapp.jar /
EXPOSE 9800
ENV PROJECT_DEFAULT_NAME=server-test-app PROJECT_DEFAULT_VERSION=v1.0.0
ENTRYPOINT java ${JAVA_OPTS} -jar /server-test-webapp.jar
