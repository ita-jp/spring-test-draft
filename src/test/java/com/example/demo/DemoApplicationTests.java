package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.IndexController;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private IndexController indexController;

	@Test
	void contextLoads() {
		assertThat(indexController).isNotNull();
	}

}
