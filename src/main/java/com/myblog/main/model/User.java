package com.myblog.main.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer uId;
	private String fName;
	private String lName;
	private String gender;
	private String emailId;
	private String phoneNo;
	
	@OneToMany
	private List<Post> post;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	

	public User(Integer uId, String fName, String lName, String gender, String emailId, String phoneNo,
			List<Post> post) {
		super();
		this.uId = uId;
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.post = post;
	}

	public User() {
		
	}
	
	
	
}
