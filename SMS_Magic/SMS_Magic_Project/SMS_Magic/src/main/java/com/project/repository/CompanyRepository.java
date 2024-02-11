package com.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>{

	public Optional<Company> findByName(String name);
	
	
}
