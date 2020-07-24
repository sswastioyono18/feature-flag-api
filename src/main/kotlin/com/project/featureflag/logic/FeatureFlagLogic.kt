package com.project.featureflag.logic

import com.project.featureflag.entity.FeatureFlagEntity

interface FeatureFlagLogic {
    fun getFeatureFlag(applicationName : String) : FeatureFlagEntity?
}