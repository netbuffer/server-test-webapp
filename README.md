# server-test-webapp
> echo server information/server io test ...

### docker images
* https://hub.docker.com/repository/docker/javawiki/server-test-webapp
* docker build -f Dockerfile -t javawiki/server-test-webapp:1.0.4 .
* docker pull javawiki/server-test-webapp:1.0.4

### web api for test
* curl "http://localhost:9800/server/io/write?path=/root/test.txt&message=hello"
* curl "http://localhost:9800/server/io/read?path=/root/test.txt"
* curl "http://localhost:9800/server/info/properties"
* curl "http://localhost:9800/server/info/env"

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides

The following guides illustrate how to use some features concretely:
* https://docs.spring.io/spring-boot/docs/2.6.6/reference/htmlsingle/
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

