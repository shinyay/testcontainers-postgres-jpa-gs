package io.spring.shinyay.test.service

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.logger
import io.spring.shinyay.test.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookRepository) {

    fun storeBook(book: Book) = repository.save(book)

    fun getBooks(): MutableList<Book> = repository.findAll()

    fun getBooksByAuthor(name: String): List<Book> {
        logger.info("getBookByAuthor: $name")
        return repository.findByAuthor(name)
    }

    fun getBookById(id: Long): Book? {
        logger.info("getBookById: $id")
        return repository.findById(id).orElse(null)
    }

}
