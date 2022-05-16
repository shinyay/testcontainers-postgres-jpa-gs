package io.spring.shinyay.test.service

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.logger
import io.spring.shinyay.test.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun storeBook(book: Book) = bookRepository.save(book)

    fun getBooks(): MutableList<Book> = bookRepository.findAll()

    fun getBooksByName(name: String): List<Book> {
        logger.info("getBookByName: $name")
        return bookRepository.findByName(name)
    }
}
