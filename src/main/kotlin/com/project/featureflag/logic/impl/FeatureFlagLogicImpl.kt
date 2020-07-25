package com.project.featureflag.logic.impl

import com.project.featureflag.entity.FeatureFlagEntity
import com.project.featureflag.logic.FeatureFlagLogic
import com.project.featureflag.repository.FeatureFlagRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class FeatureFlagLogicImpl : FeatureFlagLogic {

    @Autowired
    private lateinit var featureFlagRepository : FeatureFlagRepository

    override fun getFeatureFlag(applicationName : String): Optional<FeatureFlagEntity> {
        return featureFlagRepository.findById(applicationName)
    }
}