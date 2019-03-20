package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.dm.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByName(String name);
	
}
