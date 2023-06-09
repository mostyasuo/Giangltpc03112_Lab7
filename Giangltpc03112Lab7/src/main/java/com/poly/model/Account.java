package com.poly.model;


import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "Username")
	String username;
	
	@Column(name = "Password")
	String password;
	
	@Column(name = "Fullname")
	String fullname;
	
	@Column(name = "Email")
	String email;
	
	@Column(name = "Photo")
	String photo;
	
	@Column(name = "Activated")
	boolean activated;
	
	@Column(name = "Admin")
	boolean admin;
//	
	@OneToMany(mappedBy = "account")
	List<Order> orders;
}
