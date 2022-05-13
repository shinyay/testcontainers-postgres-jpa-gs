package io.spring.shinyay.test

import org.springframework.boot.test.context.SpringBootTest
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
class BookPostgreSQLContainerTest : AbstractContainerBaseTest() {
}
