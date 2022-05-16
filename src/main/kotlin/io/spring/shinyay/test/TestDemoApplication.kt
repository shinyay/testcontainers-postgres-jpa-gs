package io.spring.shinyay.test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestDemoApplication

fun main(args: Array<String>) {
	runApplication<TestDemoApplication>(*args)
}

val Any.logger get() = org.slf4j.LoggerFactory.getLogger(this::class.java)
