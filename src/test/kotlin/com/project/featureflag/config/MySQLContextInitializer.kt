package com.project.featureflag.config

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.MySQLContainer


class MySQLContextInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {

    override fun initialize(context: ConfigurableApplicationContext) {
        mysqlSQLContainer.start()
        TestPropertyValues.of(
                "spring.datasource.url=" + mysqlSQLContainer.jdbcUrl,
                "spring.datasource.username=" +mysqlSQLContainer.username,
                "spring.datasource.password=" + mysqlSQLContainer.password
        ).applyTo(context.environment)
    }

    companion object {
        var mysqlSQLContainer =  MySQLContainer<MysqlContainer>("mysql:8.0.11")
    }

    class MysqlContainer(imageName: String?) : MySQLContainer<MysqlContainer>(imageName)
}