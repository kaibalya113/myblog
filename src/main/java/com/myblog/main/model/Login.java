package com.myblog.main.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String emailId;
	private String password;
	private String role;
	private Date loginTime;
	private boolean isActive;
	private String uniqueNo;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getUniqueNo() {
		return uniqueNo;
	}
	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}
	public Login(Integer id, String emailId, String password, String role, Date loginTime, boolean isActive,
			String uniqueNo) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
		this.role = role;
		this.loginTime = loginTime;
		this.isActive = isActive;
		this.uniqueNo = uniqueNo;
	}
	public Login() {
		
	}
	public Login(String emailId, String password) {
		super();
		this.emailId = emailId;
		this.password = password;
	}

	
	

}
