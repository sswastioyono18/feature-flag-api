package com.project.featureflag.controller

import com.project.featureflag.entity.FeatureFlagEntity
import com.project.featureflag.exception.RecordNotFoundException
import com.project.featureflag.service.FeatureFlagService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api")
class FeatureFlagController {
    @Autowired
    private lateinit var featureFlagService: FeatureFlagService


    @GetMapping("/feature/{applicationName}")
    fun getApplicationFeature(@PathVariable(value = "applicationName") applicationName: String): ResponseEntity<FeatureFlagEntity> {
        return featureFlagService.getFeatureFlag(applicationName).map { feature ->
            ResponseEntity.ok(feature)
        }.orElseThrow { RecordNotFoundException(applicationName) }
    }
}