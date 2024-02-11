package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.client;
import com.project.entity.user;

@Repository
public interface UserRepository extends JpaRepository<user, Long>{

	public Optional<user> findByUsername(String username);
	
	public List<user> findAllByusername(String username);
	
	public List<user> findAllByrole(String role);
}
