package com.project.featureflag.service.impl

import com.project.featureflag.entity.FeatureFlagEntity
import com.project.featureflag.logic.FeatureFlagLogic
import com.project.featureflag.service.FeatureFlagService
import org.springframework.stereotype.Service
import org.tinylog.kotlin.Logger
import java.util.*

@Service
class FeatureFlagServiceImpl(val featureFlagLogic: FeatureFlagLogic) : FeatureFlagService {


    override fun getFeatureFlag(applicationName: String): Optional<FeatureFlagEntity> {
        Logger.info{ "Getting feature flag for application: $applicationName" }
        return featureFlagLogic.getFeatureFlag(applicationName)
    }
}
