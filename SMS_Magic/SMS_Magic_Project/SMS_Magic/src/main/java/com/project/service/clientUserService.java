package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.client;
import com.project.entity.clientUsers;
import com.project.repository.ClientUserRepository;

@Service
public class clientUserService {

	@Autowired
	private ClientUserRepository cur;
	
	public List<clientUsers> findAllByuser_id(long user_id)
	{
		List<clientUsers> clientUsersList=cur.findAllByuser_id(user_id);
		return clientUsersList;
	}
	
	public List<clientUsers> findAllByclient_id(long client_id)
	{
		List<clientUsers> clientUsersList=cur.findAllByclient_id(client_id);
		return clientUsersList;
	}
	
	
	
}
