package com.testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestingSpApplicationTests {

	@Test
	void contextLoads() {
	}
	
	void verif()
	{
		assertTrue(1>20);
	}

}
