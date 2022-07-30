FROM openjdk:8-slim-buster
LABEL author="netbuffer"
WORKDIR /
ADD target/server-test-webapp.jar /
EXPOSE 9100
ENTRYPOINT java ${JAVA_OPTS} -jar /server-test-webapp.jar