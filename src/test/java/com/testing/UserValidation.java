package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.testing.model.User;

import jakarta.validation.ConstraintViolation;

@DataJpaTest
public class UserValidation {
	private final LocalValidatorFactoryBean validator =  new LocalValidatorFactoryBean();

	@Test
	void testValidUser() {
	User user = new User();
	user.setId(1L);
	user.setUsername("ValidUsername");
	Set<ConstraintViolation<User>> violations = validator.validate(user);
	assertEquals(0, violations.size());
	}

	
	
	
	
}
