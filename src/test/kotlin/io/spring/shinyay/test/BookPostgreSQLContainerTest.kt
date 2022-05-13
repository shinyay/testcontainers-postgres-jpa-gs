package io.spring.shinyay.test

import io.spring.shinyay.test.repository.BookRepository
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class BookPostgreSQLContainerTest(
    @Autowired
    val mockMvc: MockMvc,
    @Autowired
    val repository: BookRepository
) : AbstractContainerBaseTest() {

    @BeforeEach
    fun setUp() = repository.deleteAll()
}
