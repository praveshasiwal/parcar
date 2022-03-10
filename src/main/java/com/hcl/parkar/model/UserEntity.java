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
	private String lastName;
	@Column(nullable = false, unique = true, length = 45)
	private String Email;
	@Column(nullable = false, length = 10)
	private int mobileNumber;
	@Column(nullable = false, length = 64)
	private String Password;
	public String getPassword() {
	return Password;
	}
	public void setPassword(String password) {
	this.Password = password;
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
	return lastName;
	}
	public void setLastName(String lastName) {
	lastName = lastName;
	}
	public String getEmail() {
	return Email;
	}
	public void setEmail(String email) {
	this.Email = email;
	}
	public int getMobileNumber() {
	return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
	mobileNumber = mobileNumber;
	}
	}
