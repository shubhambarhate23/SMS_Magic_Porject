package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Company;
import com.project.entity.client;
import com.project.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository cr1;
	
	public Company findByName(String name)
	{
		Company company= cr1.findByName(name).orElse(null);
		return company;
	}
}
