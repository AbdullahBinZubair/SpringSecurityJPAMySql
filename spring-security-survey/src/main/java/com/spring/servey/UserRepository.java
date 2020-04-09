package com.spring.servey;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.servey.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByName(String username);

}
