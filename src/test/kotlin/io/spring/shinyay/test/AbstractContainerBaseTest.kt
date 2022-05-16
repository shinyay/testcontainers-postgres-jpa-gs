package io.spring.shinyay.test

import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container

abstract class AbstractContainerBaseTest() {

    companion object {
        @Container
        val postgres = PostgreSQLContainer<Nothing>("postgres:14.2-alpine")

        @DynamicPropertySource
        @JvmStatic
        fun registerDynamicProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl)
            registry.add("spring.datasource.username", postgres::getUsername)
            registry.add("spring.datasource.password", postgres::getPassword)
        }
    }
}
