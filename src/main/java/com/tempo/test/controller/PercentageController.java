package com.tempo.test.controller;

import com.tempo.test.dto.PercentageDto;
import com.tempo.test.service.PercentageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Tag(name = "percentage")
@RestController
@RequestMapping(value = "/v1/percentage")
@CrossOrigin
@AllArgsConstructor
public class PercentageController {

	private  final PercentageService percentageService;


	@GetMapping(value = "/current")
	public ResponseEntity<PercentageDto>  getCurrent() {
		return ResponseEntity.ok().body(percentageService.getCurrent());
	}

	
	


}
