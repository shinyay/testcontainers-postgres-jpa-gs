package io.spring.shinyay.test.repository

import io.spring.shinyay.test.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {

    fun findByAuthor(author: String): List<Book>
}
