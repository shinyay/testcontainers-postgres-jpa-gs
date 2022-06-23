package io.spring.shinyay.test.service

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.logger
import io.spring.shinyay.test.repository.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun storeBook(book: Book) = ResponseEntity.status(HttpStatus.CREATED).body(repository.save(book))

    fun getBooks(): MutableList<Book> = repository.findAll()

    fun getBooksByAuthor(name: String): List<Book> {
        logger.info("getBookByAuthor: $name")
        return repository.findByAuthor(name)
    }

    fun getBookById(id: Long): Book? {
        logger.info("getBookById: $id")
        return repository.findById(id).orElse(null)
    }

    fun updateBook(id: Long, book: Book): ResponseEntity<Book> {
        logger.info("putBook: $id")
        return repository.findById(id).map {
            it.title = book.title
            it.author = book.author
            it.year = book.year
            ResponseEntity.status(HttpStatus.NO_CONTENT).body(repository.save(it))
        }.orElse(
            ResponseEntity.status(HttpStatus.CREATED).body(repository.save(book))
        )
    }

    fun deleteBookById(id: Long) {
        logger.info("deleteBook: $id")
    }

}
