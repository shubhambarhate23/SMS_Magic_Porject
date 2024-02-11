package com.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String password;
    
    @OneToMany(mappedBy = "company")
    private List<user> users;
    
    private String Department_Type;
    
    @OneToOne(mappedBy = "company")
    private client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<user> getUsers() {
		return users;
	}

	public void setUsers(List<user> users) {
		this.users = users;
	}

	public client getClient() {
		return client;
	}

	public void setClient(client client) {
		this.client = client;
	}

	

	public String getDepartment_Type() {
		return Department_Type;
	}

	public void setDepartment_Type(String department_Type) {
		Department_Type = department_Type;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(Long id, String name, String password, List<user> users, String department_Type,
			com.project.entity.client client) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.users = users;
		Department_Type = department_Type;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", password=" + password + ", users=" + users
				+ ", Department_Type=" + Department_Type + ", client=" + client + "]";
	}

    
    
}