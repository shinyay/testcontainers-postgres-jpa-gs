# TestContainer with Spring Data JPA and PostgreSQL

Testcontainers is a Java library that supports JUnit tests, providing lightweight, throwaway instances of common databases, Selenium web browsers, or anything else that can run in a Docker container.

## Description

`Spring Data JPA` is a popular ORM for Java that is used in the Spring framework.
`PostgreSQL` is a popular database that is used in the Spring framework.
In this tutorial, we will use `Spring Data JPA` and `PostgreSQL` to create a simple application that uses `Testcontainers` to run a containerized database.

This tutorial
- Unit Tests: Slice Test with `@DataJpaTest`
- Integration Tests: Slice Test with `@SpringBootTest` and `@AutoConfigureMockMvc`

### Code Sample

#### Entity

- Auto generated ID

```kotlin
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0
```

##### Strategy

###### `GenerationType.IDENTITY`
  - MySQL
  - PostgreSQL
  - SQL Server
  - DB2

This type of generation relies on the IdentityGenerator, which expects values generated by an identity column in the database.

Column type should be `SERIAL`

```sql
id SERIAL NOT NULL
```

###### `GenerationType.SEQUENCE`

  - Oracle
  - PostgreSQL
  - DB2
  - H2DB

This generator uses sequences if your database supports them.

Need to create Sequence Object specified by `SequeceName`

```sql
CREATE SEQUENCE userid_seq
    INCREMENT 1
    MINVALUE 1
    MAXVALUE 10000
    START 1
    CACHE 1
    CYCLE;
```

######  `GenerationType.TABLE`

The TableGenerator uses an underlying database table that holds segments of identifier generation values.

###### `GenerationType.AUTO`

If you're using the default generation type, the persistence provider will determine values based on the type of the primary key attribute. This type can be numerical or UUID.

#### Unit Test

In order to use TC in @DataJpaTest you need to make sure that the application defined (auto-configured) datasource is used.
You can do it easily by annotating your test with @AutoConfigureTestDatabase as shown below:

```kotlin
@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryTest
```

#### Integration Test

`@SpringBootTest` will use application defined datasource

```kotlin
@Testcontainers
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
class BookPostgreSQLContainerTest
```

#### Flyway

Flyway is an open-source database migration tool.
- [flywaydb.org](https://flywaydb.org/)

1. [Initialize Schema](src/test/resources/db/migration/V001__init.sql)
2. [Test Data](src/test/resources/db/migration/V002__insert_books.sql)

## Demo

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

## Features

- feature:1
- feature:2

## Requirement

### Dependencies

- `PostgreSQL`
```yaml
dependencies {
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.testcontainers:postgresql")
}
```

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
