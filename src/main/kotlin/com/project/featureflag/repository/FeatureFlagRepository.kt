package com.project.featureflag.repository

import com.project.featureflag.entity.FeatureFlagEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FeatureFlagRepository : JpaRepository<FeatureFlagEntity?, String?> {
    fun findOneByApplicationName(applicationName: String?): FeatureFlagEntity?
}