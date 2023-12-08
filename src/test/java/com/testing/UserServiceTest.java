package com.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.testing.model.User;
import com.testing.repo.UserRepository;
import com.testing.services.UserService;

@SpringBootTest

public class UserServiceTest {
	@Mock
	private UserRepository userRepository;
	@InjectMocks
	private UserService userService;
	@Test
	void testGetUserById() {
	when(userRepository.findById(1L)).thenReturn(Optional.of(new User(1L, "John Stones")));
	User result = userService.getUserById(1L);
	assertEquals("John Doe", result.getUsername());
	}
}
