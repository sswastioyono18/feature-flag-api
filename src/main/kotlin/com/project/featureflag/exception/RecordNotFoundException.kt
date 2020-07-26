package com.project.featureflag.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class RecordNotFoundException(exception: String?) : RuntimeException("$exception does not exist in DB") {
}
