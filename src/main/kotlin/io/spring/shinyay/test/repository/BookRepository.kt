package io.spring.shinyay.test.repository

import io.spring.shinyay.test.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {

    fun findByAuthor(author: String): MutableList<Book>

    fun updateBook(id: Long, book: Book): Book {
        val bookToUpdate = findById(id).get()
        bookToUpdate.title = book.title
        bookToUpdate.author = book.author
        bookToUpdate.year = book.year
        return save(bookToUpdate)
    }
}
