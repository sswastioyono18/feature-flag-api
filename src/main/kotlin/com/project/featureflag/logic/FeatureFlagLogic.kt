package com.project.featureflag.logic

import com.project.featureflag.entity.FeatureFlagEntity
import java.util.Optional

interface FeatureFlagLogic {
    fun getFeatureFlag(applicationName : String) : Optional<FeatureFlagEntity>
}