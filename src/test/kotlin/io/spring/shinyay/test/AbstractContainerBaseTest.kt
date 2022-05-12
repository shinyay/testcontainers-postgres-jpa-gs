package io.spring.shinyay.test

import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

abstract class AbstractContainerBaseTest(var POSTGRES_SQL_CONTAINER: PostgreSQLContainer<*>?) {

    companion object {
        val postgres = PostgreSQLContainer<Nothing>(DockerImageName.parse("postgres:14.2-alpine"))
        init {
            postgres.start()
        }
    }
}
