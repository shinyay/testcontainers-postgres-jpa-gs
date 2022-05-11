package io.spring.shinyay.test.service

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun saveBook(book: Book) = bookRepository.save(book)

    fun findAll() = bookRepository.findAll()
}
