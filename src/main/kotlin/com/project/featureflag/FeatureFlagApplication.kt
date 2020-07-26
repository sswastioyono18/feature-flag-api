package com.project.featureflag

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class FeatureFlagApplication

fun main(args: Array<String>) {
	runApplication<FeatureFlagApplication>(*args)
}
