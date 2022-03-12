FROM openjdk:8-alpine
LABEL author="netbuffer" version="1.0"
WORKDIR /
ADD target/server-test-webapp.jar /
EXPOSE 9100
ENTRYPOINT java -jar /server-test-webapp.jar