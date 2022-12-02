# Proof of concept for API Testing

This is an automation test project using Serenity BDD with implementation of the Screenplay Pattern, and other tools as Cucumber, Junit,
Serenity REST, Java language, Maven as build and dependencies management tool. API to test is dummyapi.io (https://dummyapi.io/docs)

This project was created as a proof of concept for API Testing using Serenity REST  


<!-- Table of Contents -->
## Table of Contents
  - [What do you need 🛠️](#what-do-you-need-before-downloading-the-repository-)
  - [About Screenplay pattern 🧮](#about-screenplay-pattern-and-rest-apis-)
  - [Project structure 🗼](#project-structure-)
  - [Compilation ⚙️](#compilation-)
  - [Execution 🚀](#execution-)
  - [Author 🌍🔭](#author-)
<!-- TOC -->


## What do you need before downloading the repository 🛠️ ##

- JDK 1.8
- Maven
- Git

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
    │   │   │        │   └───builder        # Classes created for using the Builder pattern
    │   │   │        ├───questions          # Layer of screenplay pattern that help validating application state in assertions
    │   │   │        ├───tasks              # High level actions made for Actor in screenplay pattern
    │   │   │        └───utils              # Classes and methods for using in any place of the project
    │   │   └───resources
    │   └───test
    │       ├───java
    │       │   └───com.carlos.automation
    │       │       ├───runners             # Classes for executing tests
    │       │       └───stepdefinitions     # Layer of screenplay pattern for maping cucumber steps to Java methods
    │       └───resources
    │           └───features
    │               └───users               # Files with test scenarios in gherkin language 
    └── target                              # This folder will be showed once tests are executed using command explained in next sections of this Readme file
    └── pom.xml                             # File for dependencies management and their versions
    └── serenity.properties                 # File with settings about Serenity framework 
## Compilation ⚙️

Once the project has been downloaded, import it into IDE of preference.

It is important to compile the project, for this, execute the following command.
Run by console

```
mvn clean compile
```

## Execution 🚀

**Execution All tests**

To run all tests of this project and to generate the Serenity report you can use next command.

```
mvn clean verify
```

**NOTE:** The report generated from tests execution is generated in the path `/target/site/serenity/index.html`

## Author 🌍🔭
- [Carlos Armando Oliva Paredes,](https://github.com/caolivap)
  Test Automation Engineer