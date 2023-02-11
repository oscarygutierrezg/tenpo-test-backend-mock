package com.tenpo.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tenpo.test")
public class TestBackendTenpoMockApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBackendTenpoMockApplication.class, args);
	}
}
