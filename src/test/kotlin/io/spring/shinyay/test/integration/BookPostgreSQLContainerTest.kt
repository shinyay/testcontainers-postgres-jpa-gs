package io.spring.shinyay.test.integration

import com.fasterxml.jackson.databind.ObjectMapper
import io.spring.shinyay.test.AbstractContainerBaseTest
import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.repository.BookRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class BookPostgreSQLContainerTest(
    @Autowired
    val mockMvc: MockMvc,
    @Autowired
    val objectMapper: ObjectMapper,
    @Autowired
    val repository: BookRepository
) : AbstractContainerBaseTest() {

//    @BeforeEach
//    fun setUp() = repository.deleteAll()

    @Test
    @Order(1)
    fun should_return_ok_when_get_all_books() {

        // given
        // V002_insert_book_data.sql

        // when & then
        mockMvc.perform(get("/api/v1/books"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
    }

    @Test
    @Order(2)
    fun should_return_three_when_get_all_books() {

        // given
        // V002_insert_book_data.sql

        // when & then
        mockMvc.perform(get("/api/v1/books"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.length()").value(3))
    }

    @Test
    @Order(3)
    fun should_return_four_attributes_when_get_one_book() {

        // given
        // V002_insert_book_data.sql

        // when & then
        // id, author, title, year
        mockMvc.perform(get("/api/v1/book/1"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.length()").value(4))
    }

    @Test
    @Order(4)
    fun should_return_the_first_book_when_get_one_book() {

        // given
        // V002_insert_book_data.sql

        // when & then
        // id, author, title, year
        mockMvc.perform(get("/api/v1/book/1"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.title").value("Spring Framework 6"))
            .andExpect(jsonPath("$.author").value("shinyay"))
            .andExpect(jsonPath("$.year").value("2022"))
    }

    @Test
    @Order(5)
    fun should_return_the_specific_book_when_get_all_books() {

        // given
        // V002_insert_book_data.sql

        // when & then
        mockMvc.perform(get("/api/v1/books"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].title").value("Spring Framework 6"))
            .andExpect(jsonPath("$[0].author").value("shinyay"))
            .andExpect(jsonPath("$[0].year").value("2022"))
    }

    @Test
    @Order(6)
    fun should_return_the_specific_books_when_get_all_books() {

        // given
        // V002_insert_book_data.sql

        // when & then
        mockMvc.perform(get("/api/v1/books"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].title").value("Spring Boot 3"))
            .andExpect(jsonPath("$[1].author").value("shinyay"))
            .andExpect(jsonPath("$[1].year").value("2022"))
            .andExpect(jsonPath("$[2].id").value(3))
            .andExpect(jsonPath("$[2].title").value("Spring Cloud"))
            .andExpect(jsonPath("$[2].author").value("yanagiharas"))
            .andExpect(jsonPath("$[2].year").value("2021"))
    }

    @Test
    @Order(7)
    fun should_return_the_added_book_when_insert_one_book() {

        // given
        val json = objectMapper.writeValueAsString(
            Book(
                author = "yanagiharas",
                title = "Spring in Action",
                year = 2021
            )
        )

        // when & then
        mockMvc.perform(post("/api/v1/books")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andDo(print())
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(4))
            .andExpect(jsonPath("$.title").value("Spring in Action"))
            .andExpect(jsonPath("$.author").value("yanagiharas"))
            .andExpect(jsonPath("$.year").value("2021"))
    }

    @Test
    @Order(8)
    fun should_return_the_added_book_when_get_one_book() {

        // given
        val json = objectMapper.writeValueAsString(
            Book(
                author = "yanagiharas",
                title = "Spring in Action",
                year = 2021
            )
        )

        // when & then
        mockMvc.perform(get("/api/v1/book/4"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(4))
            .andExpect(jsonPath("$.title").value("Spring in Action"))
            .andExpect(jsonPath("$.author").value("yanagiharas"))
            .andExpect(jsonPath("$.year").value("2021"))
    }

    @Test
    @Order(9)
    fun should_return_the_created_book_when_update_one_book() {

        // given
        val json = objectMapper.writeValueAsString(
            Book(
                id = 5,
                author = "shinyay",
                title = "Spring Boot in Practice",
                year = 2020
            )
        )

        // when & then
        mockMvc.perform(put("/api/v1/book/5")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andDo(print())
            .andExpect(status().isCreated)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(5))
            .andExpect(jsonPath("$.title").value("Spring Boot in Practice"))
            .andExpect(jsonPath("$.author").value("shinyay"))
            .andExpect(jsonPath("$.year").value("2020"))
    }

    @Test
    @Order(10)
    fun should_return_the_updated_book_when_update_one_book() {

        // given
        val json = objectMapper.writeValueAsString(
            Book(
                id = 5,
                author = "shinyay",
                title = "Spring in Practice",
                year = 2020
            )
        )

        // when & then
        mockMvc.perform(put("/api/v1/book/5")
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andDo(print())
            .andExpect(status().isNoContent)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(5))
            .andExpect(jsonPath("$.title").value("Spring in Practice"))
            .andExpect(jsonPath("$.author").value("shinyay"))
            .andExpect(jsonPath("$.year").value("2020"))
    }

    @Test
    @Order(11)
    fun should_deleted_count_when_delete_one_book() {

        // given
        val json = objectMapper.writeValueAsString(
            Book(
                id = 5,
                author = "shinyay",
                title = "Spring in Practice",
                year = 2020
            )
        )

        // when & given
        mockMvc.perform(delete("/api/v1/book/5"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        mockMvc.perform(get("/api/v1/books"))
            .andDo(print())
            .andExpect(jsonPath("$.length()").value(4))
    }
}
