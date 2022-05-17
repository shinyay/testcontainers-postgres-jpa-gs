package io.spring.shinyay.test.controller

import io.spring.shinyay.test.entity.Book
import io.spring.shinyay.test.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class BookController(val service: BookService) {

    @GetMapping("/books")
    fun getBooks(): ResponseEntity<MutableList<Book>> {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooks())
    }

    @GetMapping("/books/{name}")
    fun getBooksByAuthor(@PathVariable name: String): ResponseEntity<List<Book>> {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBooksByAuthor(name))
    }

    @GetMapping("/book/{id}")
    fun getBookById(@PathVariable id: Long): ResponseEntity<Book> {
        return ResponseEntity.status(HttpStatus.OK).body(service.getBookById(id))
    }

    @PostMapping("/books")
    fun storeBook(@RequestBody book: Book): ResponseEntity<Book> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.storeBook(book))
    }
}

