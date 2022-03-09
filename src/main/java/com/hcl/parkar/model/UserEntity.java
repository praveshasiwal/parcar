package com.hcl.parkar.model;


	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;




	@Entity
	@Table(name= "users")
	public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 20)
	private String firstName;
	@Column(nullable = false, length = 20)
	private String LastName;
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(nullable = false, length = 10)
	private int MobileNumber;
	@Column(nullable = false, length = 64)
	private String password;
	public String getPassword() {
	return password;
	}
	public void setPassword(String password) {
	this.password = password;
	}
	public long getId() {
	return id;
	}
	public void setId(long id) {
	this.id = id;
	}
	public String getFirstName() {
	return firstName;
	}
	public void setFirstName(String firstName) {
	this.firstName = firstName;
	}
	public String getLastName() {
	return LastName;
	}
	public void setLastName(String lastName) {
	LastName = lastName;
	}
	public String getEmail() {
	return email;
	}
	public void setEmail(String email) {
	this.email = email;
	}
	public int getMobileNumber() {
	return MobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
	MobileNumber = mobileNumber;
	}
	}
