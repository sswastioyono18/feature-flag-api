package com.project.featureflag

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeatureFlagController {

    @GetMapping("/getFeatureFlag")
    fun getFeatureFlagVersion(applicationName: String): String {
        return applicationName
    }
}