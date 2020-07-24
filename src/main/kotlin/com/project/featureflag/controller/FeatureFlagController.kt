package com.project.featureflag.controller

import com.project.featureflag.dto.FeatureFlagResponseDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeatureFlagController {

    @GetMapping("/getFeatureFlag")
    fun getFeatureFlagVersion(applicationName: String): FeatureFlagResponseDto {
        val c = FeatureFlagResponseDto()
        c.applicationName = applicationName
        c.version = "1.1"
        return c
    }
}