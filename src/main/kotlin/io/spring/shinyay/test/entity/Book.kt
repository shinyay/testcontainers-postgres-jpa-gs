package io.spring.shinyay.test.entity

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @Column(name = "author")
    val author: String = "",

    @Column(name = "title")
    val title: String = "",

    @Column(name = "publication_year")
    val year: Int = 0)
