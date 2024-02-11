package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.entity.client;
import com.project.entity.user;
import com.project.repository.UserRepository;

@Service
@Transactional
public class userService {

	@Autowired
	private UserRepository ur;
	
	public user findByUsername(String Username)
	{
	  user user=ur.findByUsername(Username).orElse(null);
	  return user;
	}
	public List<user> findAllByrole(String role)
	{
		List<user> user=ur.findAllByrole(role);
		return user;
		
	}
	public List<user> findAllByName(String username)
	{
		List<user> user = ur.findAllByusername(username);
		return user;
	}
}
