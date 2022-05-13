package io.spring.shinyay.test.entity

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @Column(name = "author")
    val author: String = "",

    @Column(name = "title")
    val title: String = "",

    @Column(name = "publicication_year")
    val year: Int = 0)
