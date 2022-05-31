# TestContainer with Spring Data JPA and PostgreSQL

Testcontainers is a Java library that supports JUnit tests, providing lightweight, throwaway instances of common databases, Selenium web browsers, or anything else that can run in a Docker container.

## Description

`Spring Data JPA` is a popular ORM for Java that is used in the Spring framework.
`PostgreSQL` is a popular database that is used in the Spring framework.
In this tutorial, we will use `Spring Data JPA` and `PostgreSQL` to create a simple application that uses `Testcontainers` to run a containerized database.

This tutorial
- Unit Tests: Slice Test with `@DataJpaTest`
- Integration Tests: Slice Test with `@SpringBootTest` and `@AutoConfigureMockMvc`


### Unit Test

- Slice test with Using `@DataJpaTest`

```shell
./gradlew test --tests 'io.spring.shinyay.test.unit.RepositoryTest'
```

### Integration Test

- Slice test with Using `@SpringBootTest` and `@AutoConfigureMockMvc`

```shell
./gradlew test --tests 'io.spring.shinyay.test.BookPostgreSQLContainerTest'
```

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage

### Run PostgreSQL with Docker Compose

```shell
docker compose -f docker/compose.yml up -d
```

### POST Data

```shell
curl -X POST localhost:8080/api/v1/books -H 'Content-type:application/json' -d '{"author":"Shinya", "title":"Spring in Action", "year":"2022"}'
```

### GET Data

```shell
curl -X GET localhost:8080/api/v1/books
```

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
- twitter: https://twitter.com/yanashin18618
