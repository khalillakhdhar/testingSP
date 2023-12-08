package com.testing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testing.model.User;
import com.testing.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
private final UserService userService;
@Autowired
public UserController(UserService userService) {
this.userService = userService;
}
@GetMapping("/{userId}")
public ResponseEntity<User> getUserById(@PathVariable Long userId) {
User user = userService.getUserById(userId);
return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
}
@PostMapping()
public ResponseEntity<User> addOne(@RequestBody @Valid User user)

{
User user1=userService.addUser(user);
return ResponseEntity.ok(user1);
}
}