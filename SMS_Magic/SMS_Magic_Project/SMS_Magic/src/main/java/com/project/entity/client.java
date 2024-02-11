package com.project.entity;

import javax.persistence.*;


@Entity
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String password;
    
    private String email;
    
    private String phone;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private user user;
    
    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "client [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", phone="
				+ phone + ", user=" + user + ", company=" + company + "]";
	}

	public client(Long id, String name, String password, String email, String phone, com.project.entity.user user,
			Company company) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.user = user;
		this.company = company;
	}

	public client() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
