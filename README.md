# Prueba técnica de automatización de API para Lulobank

This is an automation test project using Serenity BDD with implementation of the Screenplay Pattern, and other tools as Cucumber, Junit,
Serenity REST, Java language, Maven as build and dependencies management tool. API to test is dummyapi.io (https://dummyapi.io/docs)

This project was created to solve the knowledge test of the company **Lulo Bank**  

<!-- TABLE OF CONTENTS -->

## Table of Contents

- [What do you need](##what-do-you-need)
- [Getting Started](##about-screenplay-pattern)
- [Project structure](##project-structure)
- [Compilation](##compilation)
- [Execution](##execution)

<!-- WHAT DO YOU NEED -->
## What do you need before downloading the repository 🛠️ ##

- Java JDK 1.8
- Maven

## About Screenplay pattern and REST API's 🧮

- ### https://johnfergusonsmart.com/working-rest-apis-using-serenity-screenplay/

## Project structure 🗼

    .
    ├───src
    │   ├───main
    │   │   ├───java
    │   │   │   └───com.carlos.automation
    │   │   │        ├───endpoints          # Endpoints to make requests
    │   │   │        ├───exceptions         # Custom exceptions 
    │   │   │        ├───models             # User defined objects
    │   │   │        │   └───builder        # Builder pattern classes
    │   │   │        ├───questions          # Layer of screenplay pattern that help giving answers to the assertions
    │   │   │        ├───tasks              # Actions for the actor in screenplay pattern
    │   │   │        └───utils              # Classes and methods for using in any project place
    │   │   └───resources
    │   └───test
    │       ├───java
    │       │   └───com.carlos.automation
    │       │       ├───runners             # Classes to execute the tests
    │       │       └───stepdefinitions     # Layer of screenplay pattern for maping cucumber steps to Java methods
    │       └───resources
    │           └───features
    │               └───users               # Files with test scenarios in gherkin language 
    └── ···
## Compilation ⚙️

Once the project has been downloaded, import it into the IDE of preference.

It is important to compile the project for this, execute one of the following commands.
Run by console

```
mvn clean compile
```

## Execution 🚀

**Execution All tests**

To run all tests of this project and to generate the Serenity report you can use.

```
mvn clean verify
```

**NOTE:** The report generated from the tests is generated in the route `/target/site/serenity/index.html`
