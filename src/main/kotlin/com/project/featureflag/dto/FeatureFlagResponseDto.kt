package com.project.featureflag.dto


class FeatureFlagResponseDto {
    var applicationName: String = "default"
    var version: String = "default"
    override fun toString(): String {
        return "FeatureFlagResponseDto(applicationName='$applicationName', version='$version')"
    }
}