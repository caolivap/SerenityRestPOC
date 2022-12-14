# Proof of concept for API Testing

This is an automation test project using Serenity BDD with implementation of the Screenplay Pattern, and other tools as Cucumber, Junit,
Serenity REST, Java language, Maven as build and dependencies management tool. API to test is dummyapi.io (https://dummyapi.io/docs)

This project was created as a proof of concept for API Testing using Serenity REST  


<!-- Table of Contents -->
## Table of Contents
  - [What do you need ๐ ๏ธ](#what-do-you-need-before-downloading-the-repository-)
  - [About Screenplay pattern ๐งฎ](#about-screenplay-pattern-and-rest-apis-)
  - [Project structure ๐ผ](#project-structure-)
  - [Compilation โ๏ธ](#compilation-)
  - [Execution ๐](#execution-)
  - [Author ๐๐ญ](#author-)
<!-- TOC -->


## What do you need before downloading the repository ๐ ๏ธ ##

- JDK 1.8
- Maven
- Git

## About Screenplay pattern and REST API's ๐งฎ

- ### https://johnfergusonsmart.com/working-rest-apis-using-serenity-screenplay/

## Project structure ๐ผ

    .
    โโโโsrc
    โ   โโโโmain
    โ   โ   โโโโjava
    โ   โ   โ   โโโโcom.carlos.automation
    โ   โ   โ        โโโโendpoints          # Endpoints to make requests
    โ   โ   โ        โโโโexceptions         # Custom exceptions 
    โ   โ   โ        โโโโmodels             # User defined objects
    โ   โ   โ        โ   โโโโbuilder        # Classes created for using the Builder pattern
    โ   โ   โ        โโโโquestions          # Layer of screenplay pattern that help validating application state in assertions
    โ   โ   โ        โโโโtasks              # High level actions made for Actor in screenplay pattern
    โ   โ   โ        โโโโutils              # Classes and methods for using in any place of the project
    โ   โ   โโโโresources
    โ   โโโโtest
    โ       โโโโjava
    โ       โ   โโโโcom.carlos.automation
    โ       โ       โโโโrunners             # Classes for executing tests
    โ       โ       โโโโstepdefinitions     # Layer of screenplay pattern for maping cucumber steps to Java methods
    โ       โโโโresources
    โ           โโโโfeatures
    โ               โโโโusers               # Files with test scenarios in gherkin language 
    โโโ target                              # This folder will be showed once tests are executed using command explained in next sections of this Readme file
    โโโ pom.xml                             # File for dependencies management and their versions
    โโโ serenity.properties                 # File with settings about Serenity framework 
## Compilation โ๏ธ

Once the project has been downloaded, import it into IDE of preference.

It is important to compile the project, for this, execute the following command.
Run by console

```
mvn clean compile
```

## Execution ๐

**Execution All tests**

To run all tests of this project and to generate the Serenity report you can use next command.

```
mvn clean verify
```

**NOTE:** The report generated from tests execution is generated in the path `/target/site/serenity/index.html`

## Author ๐๐ญ
- [Carlos Armando Oliva Paredes,](https://github.com/caolivap)
  Test Automation Engineer