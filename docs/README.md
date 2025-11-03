
# Arkenna IndieNest Backend


## Summary

Arkenna IndieNest Backend, illustrating development with Java, Spring Boot, and Spring Data JPA on MySQL Database. It also illustrates open-api documentation configuration and integration with Swagger UI.


## Features

- RESTful API

- Swagger UI

- Spring Boot Framework

- Spring Data JPA

- MySQL Database

- Domain-Driven Design



## Bounded Contexts

This version of Arkenna IndieNest Backend is divided into six bounded contexts: Project, Profile, Community,  Support, IAM, Payment,



### Project Context

The Project Context is responsible for managing the projects (games, audios, arts) of the users. It includes the following features:

- Create a new game.

- Get a game by id.

- Get all games.

- Create a new audio.

- Get an audio by id.

- Get all audios.

- Create a new art.

- Get an art by id.

- Get all arts.




### Profile Context


The Profile Context is responsible for managing the profiles and portfolios. Its features include:

- Create a new profile.

- Get a profile by id.

- Get all profiles.

- Create a new portfolio.

- Get a portfolio by id.

- Get all portfolios.



### Community Context


The Community Context is responsible for managing the publications and answers. Its features include:

- Create a new publication.

- Get a publication by id.

- Get all publications.

- Create a new answer.

- Get an answer by id.

- Get all answers.


### Support Context


The Support  Context is responsible for managing the reviews. Its features include:

- Create a new review.

- Get a review by id.

- Get all reviews.


### Payment Context


The Payment Context is responsible for managing the shopping carts. Its features include:

- Create a new shoppping cart.

- Get a shoppping cart by id.

- Get all shoppping carts.



### Identity and Access Management (IAM) Context


The IAM Context is responsible for managing platform users, including the sign in and sign up processes. It applies JSON Web Token based authorization and Password hashing. It also adds a request authorization middleware to Spring Boot Pipeline, in order to validate included token in request header on endpoints that require authorization. Its capabilities include:

- Create a new Account (Sign Up).

- Authenticate an Account (Sign In).

- Get an Account by ID.

- Get All Accounts.

- Create a new User.

- Get a User by ID.

- Get All Users.

- Use Spring Security features to implement an authorization pipeline based on request filtering.

- Generate and validate JSON Web Tokens.

- Apply Password hashing.



### Reference Documentation



For further reference, please consider the following sections:



* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)

* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/3.5.6/maven-plugin)

* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.4/maven-plugin/build-image.html)

* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.5.6/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.5.6/reference/htmlsingle/index.html#using.devtools)


* [Spring Web](https://docs.spring.io/spring-boot/docs/3.5.6/reference/htmlsingle/index.html#web)



### Guides



The following guides illustrate how to use some features concretely:



* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)

* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)

* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)



### Maven Parent overrides



Due to Maven's design, elements are inherited from the parent POM to the project POM.

While most of the inheritance is fine, it also inherits unwanted elements like `<license>` and `<developers>` from the

parent.

To prevent this, the project POM contains empty overrides for these elements.

If you manually switch to a different parent and actually want the inheritance, you need to remove those overrides.