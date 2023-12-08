package com.testing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testing.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
