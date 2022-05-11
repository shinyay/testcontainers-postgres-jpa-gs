package io.spring.shinyay.test.controller

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class BookController(val bookService: BookService) {

    @GetMapping("/books")
    fun getBooks(): MutableList<Book> = bookService.getBooks()

    @PostMapping("/books")
    fun storeBook(book: Book): Book = bookService.storeBook(book)
}

