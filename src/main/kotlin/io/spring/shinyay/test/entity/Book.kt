package io.spring.shinyay.test.entity

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    val id: Long,

    @Column(name = "author")
    val author: String,
    val title: String,
    val year: Int)
