package com.tempo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tempo.test")
public class TestBackendTempoMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBackendTempoMockApplication.class, args);
	}
}
