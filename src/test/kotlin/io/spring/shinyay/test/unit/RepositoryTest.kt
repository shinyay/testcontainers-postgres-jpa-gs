package io.spring.shinyay.test.unit

import io.spring.shinyay.test.AbstractContainerBaseTest
import io.spring.shinyay.test.repository.BookRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RepositoryTest : AbstractContainerBaseTest() {

    @Autowired
    lateinit var repository: BookRepository

    @Test
    @Order(1)
    fun should_be_able_to_find_no_books_at_initial() {
        val result = repository.findAll()
        assertThat(result.count()).isEqualTo(0)
    }
}
