# BRAVI API-Project

API Restful BRAVI

Java Spring Boot using NoSQL database and Clean Architecture

### Prerequisites

* [Java 11](https://www.java.com/pt_BR/download/) - Development Kit 
* [Git](https://git-scm.com/downloads) - Open source distributed version control system
* [IntelliJ](https://www.jetbrains.com/idea/) - Powerful source code editor (Not mandatory)

### Installing

Checkout the code from Github repository
```
$ git clone https://github.com/lordssa/contact-list-solution.git
```

Once you have maven installed on your environment, install the project dependencies via:

```
mvn clean install
```

## Running

Once you have installed dependencies, this can be run from the `CvcProjectApplication.java` main method directly,
or from a command line:
```
mvn spring-boot:run
```

The API will be available at http://localhost:8080/

### Accessing API documentation

After server up, access http://localhost:8080/swagger-ui.html. You will find a list of API services, parameters and output sample. 

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Spring Boot 2
* [Maven](https://maven.apache.org/) - Dependency Management
* [Swagger 2](https://swagger.io/) - Documentation and User Interface for the REST Service
* [MongoDB](https://www.mongodb.com/) - Document based database for general purpose

## Authors

* **Cid Soares** - *Initial work* 