package io.spring.shinyay.test

import org.testcontainers.containers.PostgreSQLContainer

abstract class AbstractContainerBaseTest(var POSTGRES_SQL_CONTAINER: PostgreSQLContainer<*>?) {
}
