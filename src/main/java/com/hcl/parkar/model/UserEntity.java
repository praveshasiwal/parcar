package com.hcl.parkar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 30)
	private String firstName;
	@Column(nullable = false, length = 30)
	private String lastName;
	@Column(nullable = false, length = 30)
	private String username;
	@Column(nullable = false, unique = true, length = 50)
	private String email;
	@Column(nullable = false, length = 10)
	private int mobileNumber;
	@Column(nullable = false, unique = true, length = 15)
	private String password;
	@Column(nullable = true, length = 40)
	private long licenseid;

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
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getlicenseid() {
		return licenseid;
	}

	public void setLicenseId(long licenseid) {
		this.licenseid = licenseid;
	}
	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}
}
