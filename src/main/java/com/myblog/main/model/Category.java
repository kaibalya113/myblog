package com.myblog.main.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.List;

@Entity
@Table(name = "category_master")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cId;
	private String categoryName;
	@OneToMany
	private List<Post> post;

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category{" +
				"cId=" + cId +
				", categoryName='" + categoryName + '\'' +
				", post=" + post +
				'}';
	}

	public Category(Integer cId, String categoryName, List<Post> post) {
		this.cId = cId;
		this.categoryName = categoryName;
		this.post = post;
	}

	public Category() {
		
	}
	
	
	
}
