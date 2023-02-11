package com.tenpo.test.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenpo.test.TestBackendTenpoMockApplication;
import com.tenpo.test.dto.PercentageDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestBackendTenpoMockApplication.class)
class PercentageControllerTest {
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mockMvc;

	@Test
	 void test_GetCurrent_Should_ShowCurrentPerPercentage_When_Invoked() throws JsonProcessingException, Exception {
		ResultActions res = mockMvc.perform(
						MockMvcRequestBuilders.get("/v1/percentage/current")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON)
				)
				.andDo(MockMvcResultHandlers.print())
				.andExpectAll(
						MockMvcResultMatchers.status().isOk()

				);



		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.andReturn());
		Assertions.assertNotNull(res.andReturn().getResponse());
		Assertions.assertNotNull(res.andReturn().getResponse().getContentAsString());
		PercentageDto percentageDto = objectMapper.readValue(res.andReturn().getResponse().getContentAsString(), PercentageDto.class);
		Assertions.assertNotNull(percentageDto);
		Assertions.assertNotNull(percentageDto.getValue());

		Assertions.assertTrue(percentageDto.getValue() >=0);
		Assertions.assertTrue(percentageDto.getValue() <=1);


	}

}


