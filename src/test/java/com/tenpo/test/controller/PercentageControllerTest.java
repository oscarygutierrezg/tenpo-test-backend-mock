package com.tenpo.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tenpo.test.dto.PercentageDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PercentageControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	@DisplayName("GET /v1/percentage/current retorna el porcentaje actual válido")
	void shouldReturnCurrentPercentage_whenGetCurrentIsCalled() throws Exception {
		// Arrange
		String url = "/v1/percentage/current";

		// Act
		String responseContent = mockMvc.perform(get(url)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn()
				.getResponse()
				.getContentAsString();

		PercentageDto percentageDto = objectMapper.readValue(responseContent, PercentageDto.class);

		// Assert
		assertThat(percentageDto).isNotNull();
		assertThat(percentageDto.getValue()).isNotNull();
		assertThat(percentageDto.getValue()).isBetween(0.0, 1.0);
	}
}