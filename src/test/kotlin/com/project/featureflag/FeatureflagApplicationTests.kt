package com.project.featureflag

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.project.featureflag.dto.FeatureFlagResponseDto
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class FeatureflagApplicationTests (@Autowired val mvc: MockMvc, @Autowired val objectMapper: ObjectMapper) {

    @Test
    fun `assert call feature flag return app name with version`() {
        val applicationName = "test"
        val mvcResult = mvc.perform(MockMvcRequestBuilders.get("/getFeatureFlag?applicationName=$applicationName").contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
                .andReturn()
        val c: FeatureFlagResponseDto
        c = objectMapper.readValue(mvcResult.response.contentAsString)
        assertEquals(c.applicationName, applicationName)
        assertEquals(c.version, "1.1")

    }

}