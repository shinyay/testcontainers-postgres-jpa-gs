package io.spring.shinyay.test.entity

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @Column(name = "author")
    var author: String = "",

    @Column(name = "title")
    var title: String = "",

    @Column(name = "publication_year")
    var year: Int = 0)
