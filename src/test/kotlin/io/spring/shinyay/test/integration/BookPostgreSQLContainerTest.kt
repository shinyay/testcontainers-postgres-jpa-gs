package io.spring.shinyay.test.integration

import com.fasterxml.jackson.databind.ObjectMapper
import io.spring.shinyay.test.AbstractContainerBaseTest
import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.repository.BookRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
class BookPostgreSQLContainerTest(
    @Autowired
    val mockMvc: MockMvc,
    @Autowired
    val objectMapper: ObjectMapper,
    @Autowired
    val repository: BookRepository
) : AbstractContainerBaseTest() {

    @BeforeEach
    fun setUp() = repository.deleteAll()

    @Test
    @Order(1)
    fun should_be_able_to_save_one_book() {
        // given
        val json = objectMapper.writeValueAsString(
            Book(author = "Shinya Yanagihara", title = "Spring Boot in Action", year = 2020)
        )

        // when & then
        mockMvc.perform(post("/api/v1/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andDo(print())
            .andExpect(status().isCreated)
        mockMvc.perform(get("/api/v1/book/1"))
            .andDo(print())
            .andExpect(jsonPath("$.length()").value(1))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Spring Boot in Action"))
//            .andExpect(MockMvcResultMatchers.jsonPath("$.year").value(2020))
    }
}