# Migros Portal Order API

It is a monolith Spring Boot project with Java 11. 
There are different APIs to serve various purposes 
like 

    -placing a new order 
    -list all orders of the customer 
    -viewing the order details

Different technologies and tools were used to accomplish technical requirements.

For example:

    - @ControllerAdvice for exception handling
    - @Aspect for logging
    - @Valid for request validations
    - MongoDb for document based database
    - JWT for securing endpoints
    - Docker for containerization
    - Maven for management and building tool
    - Log4j2 for logger implementation
    - ModelMapper for mapping
    - Springdoc for Open API Specification
    - Lombok for to minimizing the boilerplate code
    - Junit and Mockito for testing
    
# How to use

First you need to clone
    git clone https://github.com/mertkocmrt/portal
Then you need to run
    mvn clean install
to build docker image. When it is ready you can use your Docker Desktop or simply run

    docker run -d --name portal -p 8080:8080 portal
or you can just run below command and enjoy your time

    java -jar target/portal.jar
    
# Details and Assumptions
Since we don't have a front-end, you have to copy and paste id of document entries. For example you have to first add then copy the id from response object to retrieve the object with another endpoint.

First endpoint you should call is /user with username and password to authorize and use other endpoints. And there is no actual login mechanism. That is why password is useless. BUT we are using username for logging.

Again you have to carry bearer token with copying and pasting to other secured endpoint requests.


# BYE
