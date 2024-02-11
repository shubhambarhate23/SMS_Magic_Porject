package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.client;
import com.project.entity.user;

@Repository
public interface ClientRepository extends JpaRepository<client, Long>{
	
	public client findByName(String name);
	
	public List<user> findAllByName(String name);
	
	
	
}
