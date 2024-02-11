package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.client;
import com.project.entity.clientUsers;
import com.project.entity.user;
import com.project.repository.ClientRepository;
import com.project.repository.ClientUserRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private ClientUserRepository cur;
	
	@Autowired
	private clientUserService cus;
	
	public client findByName(String name)
	{
		client client= cr.findByName(name);
		return client;
	}
	
	
	
	public List<user> findAllByName(String name)
	{
		client client = cr.findByName(name);
		long id=client.getId();
		List<clientUsers> clientUsersList=cur.findAllByclient_id(id);
		List<user> userList=new ArrayList<>();
		for(clientUsers clientUsers:clientUsersList)
		{
			userList.add(clientUsers.getUser());
		}
		return userList;
	}
}
