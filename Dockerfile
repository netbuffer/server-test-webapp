FROM apache/skywalking-java-agent:8.11.0-java8
LABEL author="netbuffer"
WORKDIR /
ADD target/server-test-webapp.jar /
EXPOSE 9100
ENTRYPOINT java ${JAVA_OPTS} -jar /server-test-webapp.jar