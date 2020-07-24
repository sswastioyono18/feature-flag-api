package com.project.featureflag.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feature_flag")
class FeatureFlagEntity(
        @Id
        @GeneratedValue
        @Column(name = "id")
        var id: String? = null,
        @Column(name = "app_name")
        var applicationName: String? = null,
        @Column(name = "version")
        var version: String? = null,
        @Column(name = "creation_date_time")
        var creationDateTime: Date =  Date()) {

}
