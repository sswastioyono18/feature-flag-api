package com.project.featureflag.config

import org.springframework.boot.test.util.TestPropertyValues
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.MySQLContainer


open class MySQLBaseContainer// code
() : MySQLContainer<MySQLBaseContainer>("mysql:8.0.11") {


    companion object {
        private lateinit var container: MySQLBaseContainer

        fun getInstance(): MySQLBaseContainer? {
            return MySQLBaseContainer.container
        }
    }


    override fun start() {
        super.start()
        System.setProperty("DB_URL", MySQLBaseContainer.container.jdbcUrl)
        System.setProperty("DB_USERNAME", MySQLBaseContainer.container.username)
        System.setProperty("DB_PASSWORD", MySQLBaseContainer.container.password)
    }

    override fun stop() {
        //do nothing, JVM handles shut down
    }

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
}