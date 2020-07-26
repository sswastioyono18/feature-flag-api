package controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.project.featureflag.FeatureFlagApplication
import com.project.featureflag.config.MySQLBaseContainer
import com.project.featureflag.entity.FeatureFlagEntity
import com.project.featureflag.repository.FeatureFlagRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = [MySQLBaseContainer.MySQLContextInitializer::class], classes = [FeatureFlagApplication::class])
@AutoConfigureMockMvc
class FeatureFlagApplicationTests : MySQLBaseContainer() {

    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Autowired
    lateinit var featureFlagRepository : FeatureFlagRepository


    @BeforeEach
    fun setup() {
        var featureFlagEntity = FeatureFlagEntity()
        featureFlagEntity.applicationName = "test"
        featureFlagEntity.creationDateTime = Date()
        featureFlagEntity.version = "1.10"
        featureFlagRepository.save(featureFlagEntity)
    }

    @Test
    fun `assert call feature flag return app name with version`() {

        val mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/feature/test").contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful)
                .andReturn()

        val c: FeatureFlagEntity = objectMapper.readValue(mvcResult.response.contentAsString)
        assertEquals(c.applicationName, "test")
        assertEquals(c.version, "1.10")

    }

    @Test
    fun `assert call feature not found return RecordNotFoundException`() {
        var featureFlagEntity = FeatureFlagEntity()
        featureFlagEntity.applicationName = "test123"
        featureFlagEntity.creationDateTime = Date()
        featureFlagEntity.version = "1.10"
        featureFlagRepository.save(featureFlagEntity)
        val mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/feature/test1").contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError)
                .andReturn()

        assertEquals(mvcResult.resolvedException?.message, "test1 does not exist in DB")

    }

}