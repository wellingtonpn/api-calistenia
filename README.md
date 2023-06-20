# api-calistenia
simple api for my simple app-calistenia


# api-calistenia

[![Build Status](https://github.com/wellingtonpn/api-calistenia.svg?branch=master)](https://github.com/wellingtonpn/api-calistenia)
[![Coverage Status](https://github.com/wellingtonpn/api-calistenia/badge.svg?branch=master)](https://coveralls.io/github/codecentric/api-calistenia?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

```shell
mvn spring-boot:run
```

## Deploying the application to OpenShift

This will create:

* An ImageStream called "springboot-maven3-centos"
* An ImageStream called "api-calistenia"
* A BuildConfig called "api-calistenia"
* DeploymentConfig called "api-calistenia"
* Service called "api-calistenia"

## Copyright
