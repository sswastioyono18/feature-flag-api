package com.project.featureflag.controller

import com.project.featureflag.dto.FeatureFlagResponseDto
import com.project.featureflag.entity.FeatureFlagEntity
import com.project.featureflag.service.FeatureFlagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FeatureFlagController {
    @Autowired
    private lateinit var featureFlagService: FeatureFlagService

    @GetMapping("/getFeatureFlag")
    fun getFeatureFlagVersion( applicationName: String): FeatureFlagResponseDto {
        var featureFlagEntity : FeatureFlagEntity? = FeatureFlagEntity()
        featureFlagEntity = featureFlagService.getFeatureFlag(applicationName)
        val c = FeatureFlagResponseDto()
        if (featureFlagEntity != null) {
            c.applicationName = featureFlagEntity.applicationName.toString()
        }
        if (featureFlagEntity != null) {
            c.version = featureFlagEntity.version.toString()
        }
        return c
    }
}