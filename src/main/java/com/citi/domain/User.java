package com.citi.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="Name")
    private String userName;

    @Column(name="Email")
    private String email;

	public User(String id, String userName, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		System.out.println("getUserName in User.java");
		return userName;
	}

	public void setUserName(String userName) {
		System.out.println("getUserName in User.java");
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
    
}
