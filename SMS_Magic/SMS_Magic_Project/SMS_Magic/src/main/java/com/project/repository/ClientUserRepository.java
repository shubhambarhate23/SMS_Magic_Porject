package com.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.client;
import com.project.entity.clientUsers;

@Repository
public interface ClientUserRepository extends JpaRepository<clientUsers, Long>{

	public List<clientUsers> findAllByuser_id(long user_id);
	
	public List<clientUsers> findAllByclient_id(long client_id);
	
}
