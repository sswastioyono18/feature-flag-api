package com.project.featureflag.service

import com.project.featureflag.entity.FeatureFlagEntity
import java.util.*

interface FeatureFlagService {
    fun getFeatureFlag(applicationName : String) : Optional<FeatureFlagEntity>
}