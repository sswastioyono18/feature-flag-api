package com.project.featureflag.exception

class ErrorResponse(private val message: String,
                    private val details: List<String>)