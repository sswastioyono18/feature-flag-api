package com.project.featureflag.service

import com.project.featureflag.entity.FeatureFlagEntity

interface FeatureFlagService {
    fun getFeatureFlag(applicationName : String) : FeatureFlagEntity?
}