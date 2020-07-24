package com.project.featureflag.service.impl

import com.project.featureflag.entity.FeatureFlagEntity
import com.project.featureflag.logic.FeatureFlagLogic
import com.project.featureflag.service.FeatureFlagService
import org.springframework.stereotype.Service

@Service
class FeatureFlagServiceImpl(val featureFlagLogic : FeatureFlagLogic) : FeatureFlagService {
    override fun getFeatureFlag(applicationName: String): FeatureFlagEntity? {
       return featureFlagLogic.getFeatureFlag(applicationName)
    }
}