package io.spring.shinyay.test

import com.fasterxml.jackson.databind.ObjectMapper
import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.repository.BookRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
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

    @Test
    fun should_be_able_to_save_one_book() {
        // given
        val book = Book(author = "Shinya Yanagihara", title = "Spring Boot in Action", year = 2020)

        // when & then
        mockMvc.perform(post("/books")
            .contentType("application/json")
            .content(ObjectMapper().writeValueAsString(book))
            .accept("application/json"))
    }
}
