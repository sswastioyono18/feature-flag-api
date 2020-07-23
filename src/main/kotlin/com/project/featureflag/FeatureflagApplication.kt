package com.project.featureflag

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FeatureflagApplication

fun main(args: Array<String>) {
	runApplication<FeatureflagApplication>(*args)
}
