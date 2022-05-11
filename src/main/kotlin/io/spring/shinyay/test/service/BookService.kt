package io.spring.shinyay.test.service

import io.spring.shinyay.test.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(val bookRepository: BookRepository) {

    fun findAll() = bookRepository.findAll()
}
