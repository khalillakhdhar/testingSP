package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.aspectj.lang.annotation.Before;
import org.hibernate.validator.HibernateValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.testing.model.User;

import jakarta.validation.ConstraintViolation;

@DataJpaTest
@AutoConfigureTestDatabase(replace =Replace.NONE)

public class UserValidation {
	 private LocalValidatorFactoryBean validator;

	@BeforeEach
	void setup() {
	    validator = new LocalValidatorFactoryBean();
	    validator.setProviderClass(HibernateValidator.class);
	    validator.afterPropertiesSet();
	}
	@Test
	void testValidUser() {
	User user = new User();
	user.setId(1L);
	user.setUsername("ValidUsername");
	Set<ConstraintViolation<User>> violations = validator.validate(user);
	assertEquals(0, violations.size());
	}
	@Test
	void testInvalidBlankUsername() {
	// Création d'un utilisateur avec un nom d'utilisateur vide
	User user = new User();
	user.setId(2L);
	user.setUsername("");
	user.setAge(20);
	user.setNom("Ahmed");
	// Validation
	Set<ConstraintViolation<User>> violations = validator.validate(user);
	// Assertion : Une violation est attendue pour un nom d'utilisateur vide
	assertEquals(2, violations.size());
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
