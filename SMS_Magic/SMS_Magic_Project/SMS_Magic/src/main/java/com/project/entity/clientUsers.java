package com.project.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class clientUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "client_id")
    private client client;
  
    @ManyToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private user user;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    private Date deletedAt;
    
    private boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public client getClient() {
		return client;
	}

	public void setClient(client client) {
		this.client = client;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public clientUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public clientUsers(Long id, com.project.entity.client client, com.project.entity.user user, Date createdAt,
			Date updatedAt, Date deletedAt, boolean active) {
		super();
		this.id = id;
		this.client = client;
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.active = active;
	}

	@Override
	public String toString() {
		return "clientUsers [id=" + id + ", client=" + client + ", user=" + user + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", active=" + active + "]";
	}
    
    
    
    
}
